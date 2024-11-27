package securitysystem.securitysystem.logic.security.reactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import securitysystem.securitysystem.loggers.ViolationLogger;
import securitysystem.securitysystem.models.Room;
import securitysystem.securitysystem.models.Sensor;
import securitysystem.securitysystem.models.SensorStatus;
import securitysystem.securitysystem.models.ViolationType;
import securitysystem.securitysystem.repositories.IRoomRepository;

@Component
public class TemperatureSystemReaction extends Thread implements SystemReaction {
    private static IRoomRepository roomRepository;

    private Sensor sensor;

    public TemperatureSystemReaction() {}

    @Override
    public void react()
    {
        this.start();
    }

    @Override
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
            double temp = sensor.getRoom().getCurrentTemperature();

            if (temp > -100) {
                sensor.getRoom().setCurrentTemperature(temp - 1);
                roomRepository.save(sensor.getRoom());

                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.TEMPERATURE, "Temperature decreased");
            }
            else {
                ViolationLogger.getInstance().logViolation(sensor, sensor.getRoom(),
                        ViolationType.TEMPERATURE, "Temperature is normal!");
            }
        }
    }

    @Autowired
    public void setRoomRepository(IRoomRepository roomRepository) {
        TemperatureSystemReaction.roomRepository = roomRepository; // Інжектуємо репозиторій у статичне поле
    }
}
