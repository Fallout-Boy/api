package securitysystem.securitysystem.logic.strategies.roberystrategies;

import securitysystem.securitysystem.logic.security.reactions.RobberySystemDayReaction;
import securitysystem.securitysystem.logic.security.reactions.SystemReaction;
import securitysystem.securitysystem.wrappers.sensor.ISensor;
import securitysystem.securitysystem.wrappers.sensor.SensorWrapper;
import sun.misc.Signal;

public class DaySecurityStrategy implements SecurityStrategy{
    @Override
    public SystemReaction HandleSignal(SensorWrapper sensor) {
        return new RobberySystemDayReaction();
    }
}
