package securitysystem.securitysystem.logic.security.reactions;

import securitysystem.securitysystem.models.Sensor;

public interface SystemReaction {
    public void react();
    public void setSensor(Sensor sensor);
}
