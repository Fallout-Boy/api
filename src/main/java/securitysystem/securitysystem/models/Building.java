package securitysystem.securitysystem.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private int numberOfFloors;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
    private List<Floor> floors;

    public Building() {}

    public Building(String name, String location, int numberOfFloors) {
        this.name = name;
        this.location = location;
        this.numberOfFloors = numberOfFloors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}