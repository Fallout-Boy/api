package securitysystem.securitysystem.logic.BuildingGenerator;

import org.springframework.scheduling.Trigger;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Sensor;

import java.util.List;

public abstract class BuildingBuilder {
    public abstract BuildingBuilder setName(String name);
    public abstract BuildingBuilder setLocation(String location);
    public abstract BuildingBuilder setNumberOfFloors(List<Integer> configurationTypes);

    public abstract BuildingBuilder createFloorsAndRooms();

    public abstract Building build();

    public abstract Building setSensors(List<List<List<Sensor>>> sensors);

    public abstract Building getBuilding();

    public  ConfigurationFloorBuilder selectFloorBuilder(Integer configurationType) {
        switch (configurationType) {
            case 1:
                return new FirstConfigurationFloorBuilder();
            case 2:
                return new SecondConfigurationFloorBuilder();
            default:
                return null;
        }
    }
}