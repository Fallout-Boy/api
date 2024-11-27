package securitysystem.securitysystem.logic.BuildingGenerator;

import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Floor;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;

import java.util.ArrayList;
import java.util.List;

public class SecondConfigurationFloorBuilder  extends  AbstractConfigurationFloorBuilder{

    @Override
    public SecondConfigurationFloorBuilder createRooms() {
        floor.setRooms(new ArrayList<Room>());
        for(int i=0; i<13;i++){
            Room room = new Room();
            room.setFloor(floor);
            floor.getRooms().add(room);
        }
        return this;
    }
}
