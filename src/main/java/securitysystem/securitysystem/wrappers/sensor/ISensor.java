package securitysystem.securitysystem.wrappers.sensor;

import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.wrappers.room.IRoom;

public interface ISensor {

    public IRoom getRoom();
    public void check(IRoom room);
}
