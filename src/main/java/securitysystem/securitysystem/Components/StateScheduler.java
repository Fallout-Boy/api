package securitysystem.securitysystem.Components;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import securitysystem.securitysystem.mappers.BuildingMapper;
import securitysystem.securitysystem.mappers.KafkaMappers.BuildingKafkaMapper;
import securitysystem.securitysystem.services.Simulator.SimulatorProducerService;
import securitysystem.securitysystem.wrappers.building.BuildingWrapper;

@Component
public class StateScheduler {

    private final SimpMessagingTemplate messagingTemplate;
    private final SimulatorProducerService simulatorService;
    private final Gson gson;

    @Autowired
    public StateScheduler(SimpMessagingTemplate messagingTemplate, SimulatorProducerService simulatorService) {
        this.messagingTemplate = messagingTemplate;
        this.simulatorService = simulatorService;
        this.gson = new Gson();
        System.out.println("created");
    }

    @Scheduled(fixedRate = 2000)
    public void sendStateUpdate() {

        if (BuildingWrapper.getInstance() != null) {
            String msg = gson.toJson(BuildingMapper.toDTO(BuildingWrapper.getInstance().getBuilding()));

            messagingTemplate.convertAndSend("/topic/state", msg);
//            System.out.println("Sent: " + msg);
            System.out.println("\n\nSending: \n\n");
        //    String msgForSimulator = gson.toJson(BuildingKafkaMapper.toDTO(BuildingWrapper.getInstance().getBuilding()));
        //    simulatorService.start(msgForSimulator);
        }
    }
}