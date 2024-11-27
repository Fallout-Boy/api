package securitysystem.securitysystem.dtos;

import java.util.List;

public class FloorDTO {
    private Long id;
    private int floorNumber;
    private List<RoomDTO> rooms;

    public FloorDTO() {}

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

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}