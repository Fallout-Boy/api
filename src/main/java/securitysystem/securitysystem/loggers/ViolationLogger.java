package securitysystem.securitysystem.loggers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import securitysystem.securitysystem.dtos.ViolationDTO;
import securitysystem.securitysystem.loggers.Adapter.LocalDateTimeAdapter;
import securitysystem.securitysystem.logic.parameters.InputSimulatorMessage;
import securitysystem.securitysystem.mappers.ViolationMapper;
import securitysystem.securitysystem.models.*;
import securitysystem.securitysystem.repositories.ViolationRepository;
import securitysystem.securitysystem.wrappers.building.BuildingWrapper;

import java.time.LocalDateTime;

@Component
public class ViolationLogger {

    private static ViolationLogger instance;

    private final ViolationRepository violationRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final Gson gson;

    @Autowired
    public ViolationLogger(ViolationRepository violationRepository, SimpMessagingTemplate messagingTemplate) {
        this.violationRepository = violationRepository;
        this.messagingTemplate = messagingTemplate;
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        instance = this;
    }

    public static ViolationLogger getInstance() {
        return instance;
    }

    public void logViolation(Sensor sensor, Room room, ViolationType type, String log) {
        if (type == null) {
            throw new IllegalArgumentException("Violation type cannot be null");
        }

        Violation violation = new Violation();
        violation.setType(ViolationType.valueOf("INTRUSION"));
        violation.setLog(log);
        violation.setTimestamp(LocalDateTime.now());
        violation.setSensor(sensor);
        violation.setBuilding(BuildingWrapper.getInstance().getBuilding());

        violationRepository.save(violation);

        ViolationDTO violationDTO = ViolationMapper.toDTO(violation);

        String msg = gson.toJson(violationDTO);
        System.out.println("Sending violation: " + msg);
        messagingTemplate.convertAndSend("/topic/logs", msg);
    }
}
