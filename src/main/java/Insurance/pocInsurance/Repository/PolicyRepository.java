package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Policy;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByInsuredId(Long insuredId);
    List<Policy> findByVehicleId(Long vehicleId);
}
