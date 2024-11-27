package securitysystem.securitysystem.logic.parameters;

public class InputSimulatorMessage {
    private Integer room_id;
    private RoomChangesParameter room_changes;

    public InputSimulatorMessage() {

    }

    public InputSimulatorMessage(Integer room_id, RoomChangesParameter room_changes) {
        this.room_id = room_id;
        this.room_changes = room_changes;
    }

    public Integer getRoom_id() {
        return room_id;
    }
    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }

    public RoomChangesParameter getRoom_changes() {
        return room_changes;
    }
    public void setRoom_changes(RoomChangesParameter room_changes) {
        this.room_changes = room_changes;
    }
}
