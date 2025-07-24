package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Accountant;

public interface AccountantRepository extends JpaRepository<Accountant, Long> {
    // vuoto
}
