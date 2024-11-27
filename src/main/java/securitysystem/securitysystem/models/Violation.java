package securitysystem.securitysystem.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "violation")
public class Violation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private ViolationType type;

    private String log;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;


    public Violation() {}

    public Violation(ViolationType type, LocalDateTime timestamp, Sensor sensor, String log, Building building) {
        this.type = type;
        this.timestamp = timestamp;
        this.sensor = sensor;
        this.log = log;
        this.building = building;
    }
    public void  setBuilding(Building building) {
        this.building = building;
    }

    public Building getBuilding() {
        return building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ViolationType getType() {
        return type;
    }

    public void setType(ViolationType type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}