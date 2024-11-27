package securitysystem.securitysystem.logic.strategies.roberystrategies;

import securitysystem.securitysystem.logic.security.reactions.RobberySystemNightReaction;
import securitysystem.securitysystem.logic.security.reactions.SystemReaction;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;

public class NightSecurityStrategy implements SecurityStrategy {
    @Override
    public SystemReaction HandleSignal(SensorWrapper sensor) {
        return new RobberySystemNightReaction();
    }
}
