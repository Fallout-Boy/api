package securitysystem.securitysystem.models;

import jakarta.persistence.*;
import securitysystem.securitysystem.wrappers.sensor.ISensor;

import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "sensor_type")
public  class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SensorStatus status;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne()
    @JoinColumn(name = "sensor_setting_id", nullable = false) // Створює зовнішній ключ до SensorSetting
    private SensorSetting sensorSetting;


    public SensorSetting getSensorSetting() {
        return sensorSetting;
    }

    public void setSensorSetting(SensorSetting sensorSetting) {
        this.sensorSetting = sensorSetting;
    }
    public Sensor() {}

    public Sensor(SensorStatus status, Room room, SensorSetting sensorSetting) {
        this.status = status;
        this.room = room;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}