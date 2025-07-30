package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pocInsurance.Entity.Counterpart;

public interface CounterpartRepository extends JpaRepository<Counterpart, Long> {
}
