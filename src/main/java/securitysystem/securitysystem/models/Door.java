package securitysystem.securitysystem.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "door")
public class Door {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean opened;

    @ManyToMany(mappedBy = "doors")
    private List<Room> rooms;

    public Door() {}

    public Door(List<Room> rooms, boolean opened) {
        this.rooms = rooms;
        this.opened = opened;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}