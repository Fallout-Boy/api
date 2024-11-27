// FloorDTO.java
package securitysystem.securitysystem.dtos.KafkaSchema;

import java.util.List;

public class FloorDTO {
    private Long floorNumber;
    private List<RoomDTO> rooms;

    public FloorDTO() {}

    public Long getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Long floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDTO> rooms) {
        this.rooms = rooms;
    }
}