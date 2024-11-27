package securitysystem.securitysystem.logic.security.reactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import securitysystem.securitysystem.models.Door;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.Window;
import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.repositories.IRoomRepository;

@Component
public abstract class RobberySystemReaction extends Thread implements SystemReaction {
    protected Sensor sensor;
    protected static IRoomRepository roomRepository;

    protected RobberySystemReaction() { }

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
    public abstract void run();

    protected void sendMessageToOwner() {
        ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                ViolationType.INTRUSION, "Sent message to owner!");
    }

    protected void callThePolice() {
        ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                ViolationType.INTRUSION, "Called the police!");
    }

    @Autowired
    public void setRoomRepository(IRoomRepository roomRepository) {
        RobberySystemReaction.roomRepository = roomRepository; // Інжектуємо репозиторій у статичне поле
    }
}
