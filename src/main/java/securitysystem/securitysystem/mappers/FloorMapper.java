package securitysystem.securitysystem.mappers;

import securitysystem.securitysystem.dtos.FloorDTO;
import securitysystem.securitysystem.models.Floor;

import java.util.stream.Collectors;

public class FloorMapper {

    public static FloorDTO toDTO(Floor floor) {
        FloorDTO dto = new FloorDTO();
        dto.setId(floor.getId());
        dto.setFloorNumber(floor.getFloorNumber());
        dto.setRooms(floor.getRooms().stream().map(RoomMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }
}