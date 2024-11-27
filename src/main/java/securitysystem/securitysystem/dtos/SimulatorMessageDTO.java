package securitysystem.securitysystem.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SimulatorMessageDTO implements Serializable {
    @Expose
    private Long id;
    @Expose
    private Integer roomId;
    @Expose
    private double deltaTemperature;
    @Expose
    private int deltaSmokePercent;
    @Expose
    private double movementLevelChanges;
    @Expose
    private LocalDateTime timestamp;

    public SimulatorMessageDTO() {}

    public SimulatorMessageDTO(Long id, Integer roomId, double deltaTemperature, int deltaSmokePercent, double movementLevelChanges, LocalDateTime timestamp) {
        this.id = id;
        this.roomId = roomId;
        this.deltaTemperature = deltaTemperature;
        this.deltaSmokePercent = deltaSmokePercent;
        this.movementLevelChanges = movementLevelChanges;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public double getDeltaTemperature() {
        return deltaTemperature;
    }

    public void setDeltaTemperature(double deltaTemperature) {
        this.deltaTemperature = deltaTemperature;
    }

    public int getDeltaSmokePercent() {
        return deltaSmokePercent;
    }

    public void setDeltaSmokePercent(int deltaSmokePercent) {
        this.deltaSmokePercent = deltaSmokePercent;
    }

    public double getMovementLevelChanges() {
        return movementLevelChanges;
    }

    public void setMovementLevelChanges(double movementLevelChanges) {
        this.movementLevelChanges = movementLevelChanges;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
