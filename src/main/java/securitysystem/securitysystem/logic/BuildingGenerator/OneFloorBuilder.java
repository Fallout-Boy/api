//package securitysystem.securitysystem.logic.BuildingGenerator;
//
//import org.springframework.scheduling.Trigger;
//import securitysystem.securitysystem.models.Building;
//import securitysystem.securitysystem.models.Floor;
//import securitysystem.securitysystem.models.Room;
//import securitysystem.securitysystem.models.Sensor;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OneFloorBuilder extends BuildingBuilder {
//    private String name;
//    private String location;
//    private Building building;
//    private List<Integer> configurations;
//    private List<Floor> floors = new ArrayList<>();
//
//    @Override
//    public BuildingBuilder setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    @Override
//    public BuildingBuilder setNumberOfFloors( List<Integer> configurations) {
//        this.configurations = configurations;
//
//        return this;
//    }
//
//    @Override
//    public Building setSensors(List<List<List<Sensor>>> sensors){
//        for (int i = 0; i < configurations.size(); i++) {
//            int c = configurations.get(i);
//            selectFloorBuilder(c)
//                    .setFloor(floors.get(i))
//                    .setSensors(sensors.get(i));
//        }
//
//        return building;
//    }
//
//    @Override
//    public BuildingBuilder setLocation(String location) {
//        this.location = location;
//        return this;
//    }
//
//    @Override
//    public Building getBuilding() {
//        return building;
//    }
//
//    @Override
//    public OneFloorBuilder createFloorsAndRooms() {
//        Floor floor = new Floor(1, null);
//        floor.setRooms(createRoomsForFloor(floor));
//        floors.add(floor);
//        return this;
//    }
//
//    public List<Room> createRoomsForFloor(Floor floor) {
//        List<Room> rooms = new ArrayList<>();
//
//        return rooms;
//    }
//
//    @Override
//    public Building build() {
//        building = new Building(name, location, 1);
//        for (Floor floor : floors) {
//            floor.setBuilding(building);
//        }
//        building.setFloors(floors);
//        return building;
//    }
//}