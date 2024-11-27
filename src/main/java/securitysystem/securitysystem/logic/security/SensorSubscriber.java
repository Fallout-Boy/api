package securitysystem.securitysystem.logic.security;

import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public interface SensorSubscriber {
    public void answerToSensorTriggered(SensorWrapper sensor);
}
