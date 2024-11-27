package securitysystem.securitysystem.mappers;

import securitysystem.securitysystem.dtos.BuildingDTO;
import securitysystem.securitysystem.models.Building;

import java.util.stream.Collectors;

public class BuildingMapper {

    public static BuildingDTO toDTO(Building building) {
        BuildingDTO dto = new BuildingDTO();
        dto.setId(building.getId());
        dto.setName(building.getName());
        dto.setLocation(building.getLocation());
        dto.setNumberOfFloors(building.getNumberOfFloors());
        dto.setFloors(building.getFloors().stream().map(FloorMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }
}