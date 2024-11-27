package securitysystem.securitysystem.logic.strategies.roberystrategies;

import securitysystem.securitysystem.logic.security.reactions.SystemReaction;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public interface SecurityStrategy {
    public SystemReaction HandleSignal(SensorWrapper sensor); //think about params
}
