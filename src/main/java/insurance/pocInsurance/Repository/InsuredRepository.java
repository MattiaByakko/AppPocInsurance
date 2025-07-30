package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Insured;

import java.util.Optional;

public interface InsuredRepository extends JpaRepository<Insured, Long> {

    Optional<Insured> findByUserEmail(String email);
}
