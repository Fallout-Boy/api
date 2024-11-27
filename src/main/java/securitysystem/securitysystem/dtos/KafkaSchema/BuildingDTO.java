package securitysystem.securitysystem.dtos.KafkaSchema;

import java.util.List;

public class BuildingDTO {
    private Long buildingId;
    private List<FloorDTO> floors;

    public BuildingDTO() {}

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public List<FloorDTO> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorDTO> floors) {
        this.floors = floors;
    }
}