package securitysystem.securitysystem.dtos;

import jakarta.persistence.*;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.SensorSetting;
import securitysystem.securitysystem.models.SensorStatus;

public class SensorDTO {

    private Long id;
    private SensorStatus status;
    private Long sensorSettingId;


    public SensorDTO() {
    }
    public SensorDTO(Long id, SensorStatus status, Long sensorSettingId) {
        this.id = id;
        this.status = status;
        this.sensorSettingId = sensorSettingId;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public SensorStatus getStatus() {
        return status;
    }
    public void setStatus(SensorStatus status) {
        this.status = status;
    }

    public Long getSensorSettingId() {
        return sensorSettingId;
    }
    public void setSensorSettingId(Long sensorSettingId) {
        this.sensorSettingId = sensorSettingId;
    }
}
