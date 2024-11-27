package securitysystem.securitysystem.logic.RoomChanger;

import securitysystem.securitysystem.logic.parameters.RoomChangesParameter;
import securitysystem.securitysystem.repositories.BuildingRepository;
import securitysystem.securitysystem.wrappers.building.BuildingWrapper;


public class RoomChanger {
    private static RoomChanger instance = null;

    private RoomChanger() {}

    public static RoomChanger getInstance() {
        if (instance == null) {
            instance = new RoomChanger();
        }
        return instance;
    }

    public void ChangeBuilding(RoomChangesParameter changes, int roomId, BuildingRepository rep) {
        BuildingWrapper buildingWrapper = BuildingWrapper.getInstance();
        if (buildingWrapper != null) {
            buildingWrapper.changeRoom(roomId, changes, rep);
        } else {
//            throw new IllegalStateException("BuildingWrapper instance is null");
        }
    }
}
