package securitysystem.securitysystem.logic.BuildingGenerator;

import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Floor;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class FirstConfigurationFloorBuilder extends AbstractConfigurationFloorBuilder {
    public FirstConfigurationFloorBuilder createFloor(int height, Building building) {
        floor = new Floor(height,building);
        floor.setRooms(new ArrayList<Room>());
       return this;
    }



    @Override
    public FirstConfigurationFloorBuilder createRooms() {
        for(int i=0; i<8;i++){
            Room room = new Room();
            room.setFloor(floor);
            floor.getRooms().add(room);
        }
        return this;
    }


    public FirstConfigurationFloorBuilder setSensors(List<List<Sensor>> sensors) {
        int index = 0;

        floor.getRooms().sort(Comparator.comparing(Room::getId));
        for (Room room : floor.getRooms()) {
            for (Sensor s : sensors.get(index)) {
                s.setRoom(room);
                room.getSensors().add(s);
            }
            index++;
        }
        return this;
    }

    public FirstConfigurationFloorBuilder setBuilding(Building building) {
        floor.setBuilding(building);
        return this;
    }

    @Override
    public Floor getFloor() {
        return floor;
    }
}
