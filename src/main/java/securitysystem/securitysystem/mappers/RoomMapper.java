package securitysystem.securitysystem.mappers;

import securitysystem.securitysystem.dtos.RoomDTO;
import securitysystem.securitysystem.models.Door;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.Window;

import java.util.stream.Collectors;

public class RoomMapper {

    public static RoomDTO toDTO(Room room) {
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setType(room.getType());
        dto.setArea(room.getArea());
        dto.setCurrentTemperature(room.getCurrentTemperature());
        dto.setCurrentSmokeLevel(room.getCurrentSmokeLevel());
        dto.setSensitivityLevel(room.getSensitivityLevel());
        dto.setNumberOfWindows(room.getNumberOfWindows());
        dto.setNumberOfDoors(room.getNumberOfDoors());
        dto.setFloorId(room.getFloor().getId());
        if (room.getDoors() != null) {
            dto.setDoorIds(room.getDoors().stream().map(Door::getId).collect(Collectors.toList()));
        }
        if(room.getSensors() != null) {
            dto.setSensors(room.getSensors().stream().map(SensorMapper::toDTO).collect(Collectors.toList()));
        }
        if(room.getWindows() != null) {
            dto.setWindowIds(room.getWindows().stream().map(Window::getId).collect(Collectors.toList()));
        }
       return dto;
    }
}