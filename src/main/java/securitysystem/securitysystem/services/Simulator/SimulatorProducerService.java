package securitysystem.securitysystem.services.Simulator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimulatorProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public SimulatorProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void start(String message) {
        kafkaTemplate.send("simulator_topic", message);
    }
}