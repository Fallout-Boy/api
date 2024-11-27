package securitysystem.securitysystem.dtos.KafkaSchema;

import securitysystem.securitysystem.dtos.KafkaSchema.SensorDTO;

import java.util.List;

public class RoomDTO {
    private Long roomId;
    private double area;
    private int windows;
    private int doors;
    private List<SensorDTO> sensors;

    public RoomDTO() {}

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public List<SensorDTO> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensors) {
        this.sensors = sensors;
    }
}