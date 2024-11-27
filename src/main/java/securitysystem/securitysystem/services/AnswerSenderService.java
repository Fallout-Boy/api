package securitysystem.securitysystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class AnswerSenderService {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public AnswerSenderService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }


    public void sendMessage(String topic, String message) {
        messagingTemplate.convertAndSend("/topic/" + topic, message);
    }
}
