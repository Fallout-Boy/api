package securitysystem.securitysystem.models;

import jakarta.persistence.*;
import securitysystem.securitysystem.wrappers.room.IRoom;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double currentTemperature;
    private int currentSmokeLevel;
    private double sensitivityLevel;
    private String type;
    private double area;
    private int numberOfWindows;
    private int numberOfDoors;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Window> windows;

    @ManyToMany
    @JoinTable(
            name = "room_door",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn(name = "door_id")
    )
    private List<Door> doors;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Sensor> sensors;

    public Room() {}

    public Room(String type, double area, int numberOfWindows, int numberOfDoors, Floor floor,
                double currentTemperature, int currentSmokeLevel, double sensitivityLevel) {
        this.type = type;
        this.area = area;
        this.numberOfWindows = numberOfWindows;
        this.numberOfDoors = numberOfDoors;
        this.floor = floor;
        this.currentTemperature = currentTemperature;
        this.currentSmokeLevel = currentSmokeLevel;
        this.sensitivityLevel = sensitivityLevel;
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

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public void setWindows(List<Window> windows) {
        this.windows = windows;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public double getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public int getCurrentSmokeLevel() {
        return currentSmokeLevel;
    }


    public void setCurrentSmokeLevel(int currentSmokeLevel) {
        this.currentSmokeLevel = currentSmokeLevel;
    }

    public double getSensitivityLevel() {
        return sensitivityLevel;
    }

    public void setSensitivityLevel(double sensitivityLevel) {
        this.sensitivityLevel = sensitivityLevel;
    }
}