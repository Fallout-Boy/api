package securitysystem.securitysystem.logic.security;

import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.logic.security.reactions.SmokeSystemReaction;
import securitysystem.securitysystem.logic.security.reactions.TemperatureSystemReaction;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.SensorStatus;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public class SmokeSystem  extends SafetySystem {
    public SmokeSystem() {

    }

    @Override
    public void answerToSensorTriggered(SensorWrapper sensor) {
        System.out.println("Smoke system triggered" + sensor.toString());
        if (sensor.getRoom().getRoom().getWindows() != null) {

            setSystemReaction(new SmokeSystemReaction());
            getSystemReaction().setSensor(sensor.getSensor());
            getSystemReaction().react();

            ViolationLogger.getInstance().logViolation(sensor.getSensor(), sensor.getRoom().getRoom(),
                    ViolationType.SMOKE, "Security system started actions");
        } else {
            ViolationLogger.getInstance().logViolation(sensor.getSensor(), sensor.getRoom().getRoom(),
                    ViolationType.SMOKE, "Security system cant do anything");
        }
    }

}
