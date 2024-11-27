package securitysystem.securitysystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import securitysystem.securitysystem.models.Room;

public interface IRoomRepository extends JpaRepository<Room, Long> {
}
