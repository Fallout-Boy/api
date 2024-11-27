package securitysystem.securitysystem.services.Simulator;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import securitysystem.securitysystem.loggers.SimulatorLogger;
import securitysystem.securitysystem.logic.RoomChanger.RoomChanger;
import securitysystem.securitysystem.logic.parameters.InputSimulatorMessage;
import securitysystem.securitysystem.repositories.BuildingRepository;
import securitysystem.securitysystem.services.SimulatorMessageSerializer;

@Service
@KafkaListener(topics = "violations_topic", groupId = "simulator_group")
public class ViolationConsumerService {
    private final BuildingRepository buildingRepository;

    public ViolationConsumerService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @KafkaHandler
    public void consumeViolation(String violation) {
        System.out.println("Received violation: " + violation);

        InputSimulatorMessage inputSimulatorMessage = SimulatorMessageSerializer
                .deserializeInputSimulatorMessage(violation);
        SimulatorLogger.getInstance().logSimulatorMessage(inputSimulatorMessage);

        RoomChanger.getInstance().ChangeBuilding(inputSimulatorMessage.getRoom_changes(),inputSimulatorMessage.getRoom_id(), buildingRepository);
    }
}