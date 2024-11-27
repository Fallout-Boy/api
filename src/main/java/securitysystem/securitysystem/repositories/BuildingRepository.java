package securitysystem.securitysystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import securitysystem.securitysystem.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}