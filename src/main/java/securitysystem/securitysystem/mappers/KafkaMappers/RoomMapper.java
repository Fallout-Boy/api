package securitysystem.securitysystem.mappers.KafkaMappers;

import securitysystem.securitysystem.dtos.KafkaSchema.RoomDTO;
import securitysystem.securitysystem.models.Room;

import java.util.stream.Collectors;

public class RoomMapper {
    public static RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setRoomId(room.getId());
        dto.setArea(room.getArea());
        dto.setWindows(room.getWindows().size());
        dto.setDoors(room.getDoors().size());
        dto.setSensors(room.getSensors().stream().map(SensorMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }
}
