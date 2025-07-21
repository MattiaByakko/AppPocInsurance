package Repository;

import Entity.Counterpart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterpartRepository extends JpaRepository<Counterpart, Long> {
}
