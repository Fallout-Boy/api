package securitysystem.securitysystem.logic.parameters;

import securitysystem.securitysystem.models.Room;

import java.lang.reflect.Type;

public interface IMessage {
    Type issueType();
    Room getRoom();
}
