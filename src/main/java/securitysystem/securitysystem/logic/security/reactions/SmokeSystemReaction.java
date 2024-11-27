package securitysystem.securitysystem.logic.security.reactions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.SensorStatus;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.repositories.IRoomRepository;

@Component
public class SmokeSystemReaction extends Thread implements SystemReaction {
    private static IRoomRepository roomRepository;

    private Sensor sensor;

    private boolean alarmInRoom = false;
    private boolean alarmInFloor = false;
    private boolean alarmInBuilding = false;

    public SmokeSystemReaction() {}

    @Override
    public void react()
    {
        this.start();
    }

    @Override
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            int smoke = sensor.getRoom().getCurrentSmokeLevel();

            if(smoke > 50 && !alarmInBuilding) {
                setAlarmInRoom(false);
                setAlarmInFloor(false);
                setAlarmInBuilding(true);
                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.SMOKE, "Alarm in building!");
            }
            else if (smoke > 25 && !alarmInFloor) {
                setAlarmInRoom(false);
                setAlarmInFloor(true);
                setAlarmInBuilding(false);
                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.SMOKE, "Alarm on the " + sensor.getRoom().getFloor().getFloorNumber() + " floor!");
            }
            else if (smoke > 0 && !alarmInRoom) {
                setAlarmInRoom(true);
                setAlarmInFloor(false);
                setAlarmInBuilding(false);
                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.SMOKE,
                        "Alarm in the room number "
                                + sensor.getRoom().getFloor().getRooms().indexOf(sensor.getRoom())
                                + "!");
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                return;
            }

            if(smoke == 0) {
                setAlarmInRoom(false);
                setAlarmInFloor(false);
                setAlarmInBuilding(false);

                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.SMOKE, "Smoke violation fixed!");
                // violation fixed
            }

            if (smoke > 1) {
                sensor.getRoom().setCurrentSmokeLevel(smoke - 1);
                roomRepository.save(sensor.getRoom());

                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.SMOKE, "Smoke level decreased!");
            }
        }
    }

    private void setAlarmInRoom(boolean alarmInRoom) {
        this.alarmInRoom = alarmInRoom;
    }

    private void setAlarmInFloor(boolean alarmInFloor) {
        this.alarmInFloor = alarmInFloor;
    }

    private void setAlarmInBuilding(boolean alarmInBuilding) {
        this.alarmInBuilding = alarmInBuilding;
    }

    @Autowired
    public void setRoomRepository(IRoomRepository roomRepository) {
        SmokeSystemReaction.roomRepository = roomRepository; // Інжектуємо репозиторій у статичне поле
    }
}
