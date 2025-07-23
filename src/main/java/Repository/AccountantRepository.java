package Repository;


import Entity.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountantRepository extends JpaRepository<Accountant, Long> {
    // vuoto
}
