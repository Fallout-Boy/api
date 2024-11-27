package securitysystem.securitysystem.logic.security;

import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.logic.security.reactions.TemperatureSystemReaction;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.SensorStatus;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public class TemperatureSystem extends SafetySystem {
    @Override
    public void answerToSensorTriggered(SensorWrapper sensor) {
        System.out.println("Temperature system triggered" + sensor.toString());

        if(sensor.getRoom().getRoom().getWindows()!=null) {
            setSystemReaction(new TemperatureSystemReaction());
            getSystemReaction().setSensor(sensor.getSensor());
            getSystemReaction().react();

            ViolationLogger.getInstance().logViolation(sensor.getSensor(), sensor.getRoom().getRoom(),
                    ViolationType.TEMPERATURE, "Security system reacted");
        } else {
            ViolationLogger.getInstance().logViolation(sensor.getSensor(), sensor.getRoom().getRoom(),
                    ViolationType.TEMPERATURE, "Security system cant do anything");
        }
    }
}
