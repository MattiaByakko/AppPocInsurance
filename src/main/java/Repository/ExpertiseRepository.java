package Repository;

import Entity.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {

    Optional<Expertise> findByClaimId(Long claimId);
}
