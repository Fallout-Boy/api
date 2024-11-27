package securitysystem.securitysystem.logic.security.reactions;

import org.springframework.stereotype.Component;
import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.models.*;

@Component
public class RobberySystemNightReaction extends RobberySystemReaction implements SystemReaction {
    public RobberySystemNightReaction() {}

    @Override
    public void run() {
        sendMessageToOwner();
        callThePolice();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            return;
        }

        double movement = sensor.getRoom().getSensitivityLevel();

        if (movement > 100) {
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
