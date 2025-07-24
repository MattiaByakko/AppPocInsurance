package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Claim;
import pocInsurance.Entity.State;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

    List<Claim> findByInsuredId(Long insuredId);

    List<Claim> findByState(State state);

    List<Claim> findByVeicoloId(Long veicoloId);
}
