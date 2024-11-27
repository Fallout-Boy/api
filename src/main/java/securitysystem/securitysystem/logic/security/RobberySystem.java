package securitysystem.securitysystem.logic.security;

import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.logic.strategies.roberystrategies.DaySecurityStrategy;
import securitysystem.securitysystem.logic.strategies.roberystrategies.NightSecurityStrategy;
import securitysystem.securitysystem.logic.strategies.roberystrategies.SecurityStrategy;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public class RobberySystem extends SafetySystem {

    private SecurityStrategy securityStrategy;

    public RobberySystem() {
        setDayStrategy();
    }

    public void setDayStrategy() {
        securityStrategy = new DaySecurityStrategy();
    }

    public void setNightStrategy() {
        securityStrategy = new NightSecurityStrategy();
    }

    @Override
    public void answerToSensorTriggered(SensorWrapper sensor) {
        System.out.println("Robbery system triggered" + sensor.toString());

        if (securityStrategy == null) {
            return;
//            throw new IllegalStateException("Security strategy is not set");
        }

        if (sensor.getRoom().getRoom() != null) {
            setSystemReaction(securityStrategy.HandleSignal(sensor));
            getSystemReaction().setSensor(sensor.getSensor());
            getSystemReaction().react();

            ViolationLogger.getInstance().logViolation(sensor.getSensor(), sensor.getRoom().getRoom(),
                    ViolationType.INTRUSION, "Security system reacted");
        } else {
            ViolationLogger.getInstance().logViolation(sensor.getSensor(), sensor.getRoom().getRoom(),
                    ViolationType.INTRUSION, "Security system did not react");
        }
    }
}