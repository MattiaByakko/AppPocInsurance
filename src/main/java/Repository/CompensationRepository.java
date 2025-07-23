package Repository;

import Entity.Compensation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {

    Optional<Compensation> findByClaimId(Long claimId);
}
