package securitysystem.securitysystem.logic.BuildingGenerator;

import org.springframework.scheduling.Trigger;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Floor;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.List;

public class ManyFloorBuilder extends BuildingBuilder {
    private String name;
    private String location;
    private Building building;

    private List<Integer> configurations;

    @Override
    public BuildingBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public BuildingBuilder setLocation(String location) {
        this.location = location;
        return this;
    }

    @Override
    public ManyFloorBuilder setNumberOfFloors( List<Integer> configurationTypes) {
       configurations = configurationTypes;
        return this;
    }

    @Override
    public ManyFloorBuilder createFloorsAndRooms() {
        building = new Building(name, location, configurations.size());
        building.setFloors(new ArrayList<>());
        for (int i = 0; i < configurations.size(); i++) {
            ConfigurationFloorBuilder builder = selectFloorBuilder(configurations.get(i));
            building.getFloors().add(builder.createFloor(i+1,building).createRooms().getFloor());
        }
        return this;
    }


    @Override
    public Building getBuilding() {
        return building;
    }

    @Override
    public Building setSensors(List<List<List<Sensor>>> sensors){
        for (int i = 0; i < configurations.size(); i++) {
            int c = configurations.get(i);
            selectFloorBuilder(c)
                    .setFloor(building.getFloors().get(i))
                    .setSensors(sensors.get(i));
        }

        return building;
    }

    @Override
    public Building build() {
        return building;
    }
}