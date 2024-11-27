package securitysystem.securitysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitysystem.securitysystem.models.SensorSetting;

import java.util.Optional;

@Repository
public interface ISensorSettingRepository extends JpaRepository<SensorSetting, Long> {

    Optional<SensorSetting> findByMaxTemperatureAndMovementAllowedLevelAndMaxSmokeLevel(
            double maxTemperature, double movementAllowedLevel, int maxSmokeLevel
    );
}
