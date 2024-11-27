package securitysystem.securitysystem.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ViolationDTO implements Serializable {
    @Expose
    private Long id;
    @Expose
    private String type;
    @Expose
    private String log;
    @Expose
    private LocalDateTime timestamp;
    @Expose
    private Long sensorId;

    public ViolationDTO() {}

    public ViolationDTO(Long id, String type, String log, LocalDateTime timestamp, Long sensorId) {
        this.id = id;
        this.type = type;
        this.log = log;
        this.timestamp = timestamp;
        this.sensorId = sensorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }
}
