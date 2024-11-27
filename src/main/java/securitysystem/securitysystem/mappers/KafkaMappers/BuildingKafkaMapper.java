package securitysystem.securitysystem.mappers.KafkaMappers;

import securitysystem.securitysystem.dtos.KafkaSchema.BuildingDTO;
import securitysystem.securitysystem.models.Building;

import java.util.stream.Collectors;

public class BuildingKafkaMapper {

    public static BuildingDTO toDTO(Building building) {
        BuildingDTO dto = new BuildingDTO();
        dto.setBuildingId(building.getId());
        dto.setFloors(building.getFloors().stream().map(FloorMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }
}