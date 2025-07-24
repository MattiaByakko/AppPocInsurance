package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Vehicle;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByTarga(String targa);
}
