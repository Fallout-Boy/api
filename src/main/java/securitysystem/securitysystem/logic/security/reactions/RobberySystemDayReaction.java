package securitysystem.securitysystem.logic.security.reactions;

import org.springframework.stereotype.Component;
import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.repositories.IRoomRepository;

@Component
public class RobberySystemDayReaction extends RobberySystemReaction implements SystemReaction {
    public RobberySystemDayReaction() {}

    @Override
    public void run() {

        sendMessageToOwner();
        callThePolice();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            return;
        }

        double movement = sensor.getRoom().getSensitivityLevel();

        if (movement > 150) {
            // via JpaRepository change to 0
            ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                    ViolationType.INTRUSION, "Failed to stop intrusion :(");

            sensor.getRoom().setSensitivityLevel(0);
            roomRepository.save(sensor.getRoom());
        }
        else {
            ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                    ViolationType.INTRUSION, "Successfully stopped intrusion :)");
            // violation fixed
        }
    }
}
