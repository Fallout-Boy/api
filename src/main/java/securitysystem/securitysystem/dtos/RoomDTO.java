package securitysystem.securitysystem.dtos;

import java.util.List;

public class RoomDTO {
    private Long id;
    private String type;
    private double area;
    private int numberOfWindows;
    private int numberOfDoors;
    private double currentTemperature;
    private int currentSmokeLevel;
    private double sensitivityLevel;
    private Long floorId;
    private List<Long> windowIds;
    private List<Long> doorIds;
    private List<SensorDTO> sensors;

    public RoomDTO() {}
    public void  setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentSmokeLevel(int currentSmokeLevel) {
        this.currentSmokeLevel = currentSmokeLevel;
    }
    public int getCurrentSmokeLevel() {
        return currentSmokeLevel;
    }

    public void setSensitivityLevel(double sensitivityLevel) {
        this.sensitivityLevel = sensitivityLevel;
    }
    public double getSensitivityLevel() {
        return sensitivityLevel;
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

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(int numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public List<Long> getWindowIds() {
        return windowIds;
    }

    public void setWindowIds(List<Long> windowIds) {
        this.windowIds = windowIds;
    }

    public List<Long> getDoorIds() {
        return doorIds;
    }

    public void setDoorIds(List<Long> doorIds) {
        this.doorIds = doorIds;
    }

    public List<SensorDTO> getSensorIds() {
        return sensors;
    }

    public void setSensors(List<SensorDTO> sensors) {
        this.sensors= sensors;
    }

    @Override
    public String toString() {
        return "RoomDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", area=" + area +
                ", numberOfWindows=" + numberOfWindows +
                ", numberOfDoors=" + numberOfDoors +
                ", floorId=" + floorId +
                ", windowIds=" + windowIds +
                ", doorIds=" + doorIds +
                ", sensorIds=" + sensors +
                '}';
    }
}