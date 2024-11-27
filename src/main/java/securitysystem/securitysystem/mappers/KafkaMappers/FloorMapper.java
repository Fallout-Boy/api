package securitysystem.securitysystem.mappers.KafkaMappers;

import securitysystem.securitysystem.dtos.KafkaSchema.FloorDTO;
import securitysystem.securitysystem.models.Floor;

import java.util.stream.Collectors;

public class FloorMapper {

    public static FloorDTO toDTO(Floor floor) {
        FloorDTO dto = new FloorDTO();
        dto.setFloorNumber(floor.getId());
        dto.setRooms(floor.getRooms().stream().map(RoomMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }
}

//{"buildingId":1,"floors": // [{ // "floorNumber":1,"rooms":[ // {"roomId":101,"area":45.5,"windows":2,"doors":1, // "sensors":[{ //}]}]}]}