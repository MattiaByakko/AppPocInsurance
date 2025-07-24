package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Compensation;

import java.util.Optional;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {

    Optional<Compensation> findByClaimId(Long claimId);
}
