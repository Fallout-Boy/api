package securitysystem.securitysystem.models;

import jakarta.persistence.*;
@Entity
@Table(name = "\"window\"")
public class Window {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean opened;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Window() {}

    public Window(Room room, boolean opened) {
        this.room = room;
        this.opened = opened;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
