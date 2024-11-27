package securitysystem.securitysystem.mappers;

import securitysystem.securitysystem.dtos.RoomDTO;
import securitysystem.securitysystem.dtos.SensorDTO;
import securitysystem.securitysystem.models.Door;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.Window;

import java.util.stream.Collectors;

public class SensorMapper {

    public static SensorDTO toDTO(Sensor sensor) {
        SensorDTO dto = new SensorDTO();
        dto.setId(sensor.getId());
        dto.setStatus(sensor.getStatus());
        dto.setSensorSettingId(sensor.getSensorSetting().getId());
        return dto;
    }
}
