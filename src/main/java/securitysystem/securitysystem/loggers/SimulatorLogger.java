package securitysystem.securitysystem.loggers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import securitysystem.securitysystem.dtos.SimulatorMessageDTO;
import securitysystem.securitysystem.loggers.Adapter.LocalDateTimeAdapter;
import securitysystem.securitysystem.logic.parameters.InputSimulatorMessage;
import securitysystem.securitysystem.mappers.SimulatorMessageMapper;
import securitysystem.securitysystem.models.SimulatorMessage;
import securitysystem.securitysystem.repositories.SimulatorMessageRepository;
import securitysystem.securitysystem.wrappers.building.BuildingWrapper;

import java.time.LocalDateTime;

@Component
public class SimulatorLogger {

    private static SimulatorLogger instance;
    private Gson gson;

    @Autowired
    private SimulatorMessageRepository simulatorMessageRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    private SimulatorLogger() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        instance = this;
    }

    public static SimulatorLogger getInstance() {
        return instance;
    }

    public void logSimulatorMessage(InputSimulatorMessage message) {
        BuildingWrapper buildingWrapper = BuildingWrapper.getInstance();
        if (buildingWrapper != null && buildingWrapper.getBuilding() != null) {
            SimulatorMessage simulatorMessage = new SimulatorMessage(message, LocalDateTime.now(), buildingWrapper.getBuilding());
            simulatorMessageRepository.save(simulatorMessage);

            SimulatorMessageDTO simulatorMessageDTO = SimulatorMessageMapper.toDTO(simulatorMessage);

            String msg = gson.toJson(simulatorMessageDTO);
            System.out.println("Sending simulator message: " + msg);
            messagingTemplate.convertAndSend("/topic/reactions", msg);
        }
    }
}