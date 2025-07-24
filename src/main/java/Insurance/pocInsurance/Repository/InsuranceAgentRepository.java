package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pocInsurance.Entity.InsuranceAgent;

import java.util.Optional;

@Repository
public interface InsuranceAgentRepository extends JpaRepository<InsuranceAgent, Long> {
    Optional<InsuranceAgent> findByEmail(String email);
}
