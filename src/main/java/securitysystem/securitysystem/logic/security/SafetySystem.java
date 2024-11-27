package securitysystem.securitysystem.logic.security;

import securitysystem.securitysystem.logic.security.reactions.SystemReaction;
import securitysystem.securitysystem.models.Building;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public abstract class SafetySystem implements SensorSubscriber {
    private SystemReaction systemReaction;

    public abstract void answerToSensorTriggered(SensorWrapper sensor);

    public SystemReaction getSystemReaction() {
        return systemReaction;
    }

    public void setSystemReaction(SystemReaction systemReaction) {
        this.systemReaction = systemReaction;
    }
}
