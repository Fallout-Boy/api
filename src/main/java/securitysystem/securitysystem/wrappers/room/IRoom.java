package securitysystem.securitysystem.wrappers.room;

import securitysystem.securitysystem.models.Room;

public interface IRoom {

    public double getCurrentTemperature();
    public int getCurrentSmokeLevel();
    public double getMovementLevel();

    public Room getRoom();
    boolean activateTemperatureReducer();
}
