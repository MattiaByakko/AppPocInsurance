package Repository;

import Entity.Claim;
import Entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findByInsuredId(Long insuredId);

    List<Claim> findByState(State state);

    List<Claim> findByVeicoloId(Long veicoloId);
}
