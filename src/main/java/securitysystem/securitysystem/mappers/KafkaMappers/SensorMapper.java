package securitysystem.securitysystem.mappers.KafkaMappers;

import securitysystem.securitysystem.dtos.KafkaSchema.SensorDTO;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.SensorSetting;

public class SensorMapper {
    public static SensorDTO toDTO(Sensor sensor) {
        SensorDTO dto = new SensorDTO();
        dto.setSensorId(sensor.getId());

        // Determine the sensor type with the maximum value
        String sensorType = determineSensorType(sensor);
        dto.setSensorType(sensorType);

        // Get the current value from the room
        double sensorValue = getCurrentValue(sensor, sensorType);
        dto.setSensorValue(sensorValue);

        // Set the thresholds
        dto.setThresholds(ThresholdsMapper.toDTO(sensor));

        // Set the status
        dto.setStatus(sensor.getStatus().name());

        return dto;
    }

    private static String determineSensorType(Sensor sensor) {
        SensorSetting settings = sensor.getSensorSetting();
        double maxValue = Math.max(settings.getMaxTemperature(),
                Math.max(settings.getMovementAllowedLevel(), settings.getMaxSmokeLevel()));

        if (maxValue == settings.getMaxTemperature()) {
            return "Temperature";
        } else if (maxValue == settings.getMovementAllowedLevel()) {
            return "Movement";
        } else {
            return "Smoke";
        }
    }

    private static double getCurrentValue(Sensor sensor, String sensorType) {
        // Assuming the room has a method to get the current value based on the sensor type
        Room room = sensor.getRoom();
        switch (sensorType) {
            case "Temperature":
                return room.getCurrentTemperature();
            case "Movement":
                return room.getSensitivityLevel();
            case "Smoke":
                return room.getCurrentSmokeLevel();
            default:
                throw new IllegalArgumentException("Unknown sensor type");
        }
    }
}

// "sensorId":1001,
// "sensorType":"Temperature",
// "sensorValue":22.5,
// "thresholds":
// { "min": 18.0, "max": 25.0 }, // "status":"Active"

