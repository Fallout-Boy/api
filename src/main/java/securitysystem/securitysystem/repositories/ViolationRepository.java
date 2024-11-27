
package securitysystem.securitysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitysystem.securitysystem.models.SensorSetting;
import securitysystem.securitysystem.models.Violation;

import java.util.Optional;

@Repository
public interface ViolationRepository extends JpaRepository<Violation, Long> {
}
