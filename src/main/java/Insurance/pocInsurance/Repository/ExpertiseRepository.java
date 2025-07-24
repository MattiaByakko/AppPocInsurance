package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Expertise;

import java.util.List;
import java.util.Optional;

public interface ExpertiseRepository extends JpaRepository<Expertise, Long> {

    Optional<Expertise> findByClaimId(Long claimId);
    Optional<Expertise> findByExpertIdAndClaimId(Long expertId, Long claimId);

    List<Expertise> findByExpertPUserUsername(String username);
}
