package securitysystem.securitysystem.wrappers.room;

import securitysystem.securitysystem.logic.parameters.RoomChangesParameter;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.repositories.BuildingRepository;
import securitysystem.securitysystem.wrappers.building.BuildingWrapper;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

import java.util.ArrayList;
import java.util.List;

public class RoomWrapper implements IRoom {
    private Room room;
    private List<SensorWrapper> sensors;


    public RoomWrapper(Room room) {
        sensors = new ArrayList<SensorWrapper>();
        this.room = room;
    }

    public void changeParameters(RoomChangesParameter parameters, BuildingRepository rep) {
        room.setCurrentTemperature(room.getCurrentTemperature() + parameters.getDeltaTemperature());
        room.setCurrentSmokeLevel(room.getCurrentSmokeLevel() + parameters.getDeltaSmokePercent());
        room.setSensitivityLevel(room.getSensitivityLevel() + parameters.getMovementLevelChanges());
        rep.save(BuildingWrapper.getInstance().getBuilding());
        sensors.forEach(s->{
            s.check(this);
        });
    }

    @Override
    public double getCurrentTemperature() {
        return room.getCurrentTemperature();
    }

    public  Room getRoom() {
        return room;
    }

    public List<SensorWrapper> getSensors() {
        return sensors;
    }
    @Override
    public int getCurrentSmokeLevel() {
        return room.getCurrentSmokeLevel();
    }

    @Override
    public double getMovementLevel() {
        return room.getSensitivityLevel();
    }


    @Override
    public boolean activateTemperatureReducer() {
        return false;
    }

    public void setup() {
        sensors = room.getSensors().stream().map(s->new SensorWrapper(s, this)).toList();
    }
}
