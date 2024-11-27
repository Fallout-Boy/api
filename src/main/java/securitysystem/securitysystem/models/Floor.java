package securitysystem.securitysystem.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int floorNumber;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    @OneToMany(mappedBy = "floor", cascade = CascadeType.ALL)
    private List<Room> rooms;

    public Floor() {}

    public Floor(int floorNumber, Building building) {
        this.floorNumber = floorNumber;
        this.building = building;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}

//message -> parse + adapter -> visitor -> visitor invoke trigger -> trigger -> invoke system