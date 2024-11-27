package securitysystem.securitysystem.dtos;

import java.util.List;

public class BuildingDTO {
    private Long id;
    private String name;
    private String location;
    private int numberOfFloors;
    private List<FloorDTO> floors;

    public BuildingDTO() {}

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

    public List<FloorDTO> getFloors() {
        return floors;
    }

    public void setFloors(List<FloorDTO> floors) {
        this.floors = floors;
    }

    @Override
    public String toString() {
        return "BuildingDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                ", floors=" + floors +
                '}';
    }
}