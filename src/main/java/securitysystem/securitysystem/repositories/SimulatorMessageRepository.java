package securitysystem.securitysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import securitysystem.securitysystem.models.SimulatorMessage;

public interface SimulatorMessageRepository extends JpaRepository<SimulatorMessage, Long> {

}