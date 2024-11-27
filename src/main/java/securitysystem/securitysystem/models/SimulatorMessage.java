package securitysystem.securitysystem.models;


import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import securitysystem.securitysystem.logic.parameters.InputSimulatorMessage;

import java.time.LocalDateTime;

@Entity
public class SimulatorMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "building_id")
    @Expose(serialize = false, deserialize = true)
    private Building building;

    private Integer room_id;

    private double  deltaTemperature;

    private int deltaSmokePercent;

    private double movementLevelChanges;

    private LocalDateTime timestamp;

    public SimulatorMessage(InputSimulatorMessage message, LocalDateTime timestamp, Building building) {
        this.room_id = message.getRoom_id();
        this.deltaTemperature = message.getRoom_changes().getDeltaTemperature();
        this.deltaSmokePercent = message.getRoom_changes().getDeltaSmokePercent();
        this.movementLevelChanges = message.getRoom_changes().getMovementLevelChanges();
        this.timestamp = timestamp;
        this.building = building;
    }

    public void  setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public SimulatorMessage() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getRoom_id() {
        return room_id;
    }
    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
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
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
