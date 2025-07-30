package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Policy;

import java.util.List;
import java.util.Optional;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByInsuredId(Long insuredId);
    Optional<Policy> findByUserId(Long userId);
    Optional<Policy> findByVehicleId(Long vehicleId);

}
