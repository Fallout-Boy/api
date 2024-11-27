package securitysystem.securitysystem.wrappers.sensor;

import securitysystem.securitysystem.logic.security.SensorSubscriber;

import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.wrappers.room.IRoom;

import java.util.ArrayList;
import java.util.List;

public class SensorWrapper implements ISensor {
    Sensor sensor;
    IRoom room;
    List<SensorSubscriber> securitySystems;

    public SensorWrapper(Sensor sensor, IRoom room) {
        this.securitySystems = new ArrayList<SensorSubscriber>();
        this.sensor = sensor;
        this.room = room;
    }

    public IRoom getRoom() {
        return  room;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public  void addSubscriber(SensorSubscriber securitySystem) {
        this.securitySystems.add(securitySystem) ;
    }

    public  void notifySystems() {
        securitySystems.forEach(sys -> sys.answerToSensorTriggered(this));
    }

    public  void check(IRoom room) {
        System.out.println("Checking sensor" + room);
        if(room.getCurrentSmokeLevel() > sensor.getSensorSetting().getMaxSmokeLevel()
                || room.getCurrentTemperature() < sensor.getSensorSetting().getMaxTemperature()
                || (room.getMovementLevel() > sensor.getSensorSetting().getMovementAllowedLevel())){
            notifySystems();
        }
    }
}
