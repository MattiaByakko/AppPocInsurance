package Repository;


import Entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByInsuredId(Long insuredId);
    List<Policy> findByVeicoloId(Long veicoloId);
}
