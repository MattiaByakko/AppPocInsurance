package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Optional<Vehicle> findByTarga(String targa);
    List<Vehicle> findByControparteId(Long controparteId);
    List<Vehicle> findByInsuredId(Long insuredId);

}
