package securitysystem.securitysystem.mappers.KafkaMappers;

import securitysystem.securitysystem.dtos.KafkaSchema.ThresholdsDTO;
import securitysystem.securitysystem.models.Sensor;

public class ThresholdsMapper {
    public static ThresholdsDTO toDTO(Sensor sensor) {
        ThresholdsDTO dto = new ThresholdsDTO();
        double currentTemperature = sensor.getRoom().getCurrentTemperature();
        dto.setMin(currentTemperature - 10);
        dto.setMax(sensor.getSensorSetting().getMaxTemperature());
        return dto;
    }
}