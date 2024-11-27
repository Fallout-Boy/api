package securitysystem.securitysystem.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/logs")
    @SendTo("/topic/logs")
    public String sendLogs(String message) {
        return "Log: " + message;
    }

//    @MessageMapping("/state")
//    @SendTo("/topic/state")
//    public String sendState(String state) {
//        return "State updated to: " + state;
//    }
}
