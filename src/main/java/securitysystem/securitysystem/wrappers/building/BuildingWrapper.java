package securitysystem.securitysystem.wrappers.building;
import securitysystem.securitysystem.logic.parameters.RoomChangesParameter;
import securitysystem.securitysystem.logic.security.RobberySystem;
import securitysystem.securitysystem.logic.security.SafetySystem;
import securitysystem.securitysystem.logic.security.SmokeSystem;
import securitysystem.securitysystem.logic.security.TemperatureSystem;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.repositories.BuildingRepository;
import securitysystem.securitysystem.wrappers.room.IRoom;
import securitysystem.securitysystem.wrappers.room.RoomWrapper;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

import java.util.ArrayList;
import java.util.List;

public class BuildingWrapper  implements IBuilding {
    private static BuildingWrapper  instance = null;
    private Building building;
    private List<RoomWrapper> rooms;
    private List<SafetySystem> systems;

    public BuildingWrapper(Building building) {
        this.building = building;
        setup();
    }

    public static BuildingWrapper getInstance() {
        return instance;
    }

    public static  void setInstance(Building building) {
       if(instance == null) {
           instance = new BuildingWrapper(building);
       }else
       {
           instance.building = building;
       }
    }

    public  Building getBuilding() {
       return building;
    }

    public void changeRoom(int room_id, RoomChangesParameter parameter, BuildingRepository rep) {
        rooms.stream().filter(r->r.getRoom().getId() == room_id).findFirst()
                .ifPresent(r->r.changeParameters(parameter, rep));
    }

    private  void setup() {
        systems = new ArrayList<>();
        systems.add(new SmokeSystem());
        systems.add(new TemperatureSystem());
        systems.add(new RobberySystem());

        rooms = building.getFloors().stream().flatMap(f-> f.getRooms().stream()).map(RoomWrapper::new).toList();
        rooms.forEach(r->r.setup());

        rooms.stream().flatMap(r->r.getSensors().stream()).forEachOrdered(sw->{
            if(sw.getSensor().getSensorSetting().getId() ==1){
                sw.addSubscriber(systems.get(2));
            }

            if(sw.getSensor().getSensorSetting().getId() ==2){
                sw.addSubscriber(systems.get(0));
            }
            if(sw.getSensor().getSensorSetting().getId() ==3){
                sw.addSubscriber(systems.get(1));
            }
        });
    }
}
