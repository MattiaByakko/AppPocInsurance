package pocInsurance.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.ExpertP;

import java.util.List;
import java.util.Optional;

public interface ExpertPRepository extends JpaRepository<ExpertP, Long> {

    List<ExpertP> findByZonaDiCompetenza(String zonaDiCompetenza);
    Optional<ExpertP> findByUserUsername(String username);
    Optional<ExpertP> findByUserId(Long userId);

}

