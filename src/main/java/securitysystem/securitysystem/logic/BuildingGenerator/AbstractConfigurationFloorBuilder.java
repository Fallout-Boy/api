package securitysystem.securitysystem.logic.BuildingGenerator;


import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Floor;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractConfigurationFloorBuilder implements ConfigurationFloorBuilder {
    protected Floor floor;

    public AbstractConfigurationFloorBuilder() {
    }

    public AbstractConfigurationFloorBuilder setFloor(Floor floor) {
        this.floor = floor;
        return this;
    }

    public AbstractConfigurationFloorBuilder createFloor(int height, Building building) {
        floor = new Floor(height, building);
        return this;
    }

    public AbstractConfigurationFloorBuilder setSensors(List<List<Sensor>> sensors) {
        int index = 0;
        for (Room room : floor.getRooms()) {
            for (Sensor s : sensors.get(index)) {
                s.setRoom(room);
                if(room.getSensors() == null) {
                    room.setSensors(new ArrayList<Sensor>());
                }
                room.getSensors().add(s);
            }
            index++;
        }
        return this;
    }

    public AbstractConfigurationFloorBuilder setBuilding(Building building) {
        floor.setBuilding(building);
        return this;
    }

    @Override
    public Floor getFloor() {
        return floor;
    }

    // Метод для створення кімнат залишається абстрактним
    public abstract AbstractConfigurationFloorBuilder createRooms();
}
