package Repository;

import Entity.ExpertP;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExpertPRepository extends JpaRepository<ExpertP, Long> {

    List<ExpertP> findByZonaDiInteresse(String zonaDiInteresse);
}

