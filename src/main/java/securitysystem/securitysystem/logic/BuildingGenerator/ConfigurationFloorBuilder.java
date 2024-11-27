package securitysystem.securitysystem.logic.BuildingGenerator;

import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Floor;
import securitysystem.securitysystem.models.Sensor;

import java.util.List;

public interface ConfigurationFloorBuilder {
   public ConfigurationFloorBuilder createFloor(int height, Building building);

  public   ConfigurationFloorBuilder createRooms();

   public ConfigurationFloorBuilder setSensors(List<List<Sensor>> sensors);

   public ConfigurationFloorBuilder setBuilding(Building building);

    public   Floor getFloor();
    public   ConfigurationFloorBuilder setFloor(Floor floor);
}
