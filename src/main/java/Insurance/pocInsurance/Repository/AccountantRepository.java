package pocInsurance.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pocInsurance.Entity.Accountant;

import java.util.Optional;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, Long> {

    // Cerca un accountant per codice fiscale (utile per evitare duplicati)
    Optional<Accountant> findByCodiceFiscale(String codiceFiscale);

    // Cerca un accountant per ID dell'utente associato
    Optional<Accountant> findByUserId(Long userId);

    // Cerca un accountant per username (tramite relazione con User)
    Optional<Accountant> findByUserUsername(String username);
}
