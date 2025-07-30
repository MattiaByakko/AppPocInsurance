package pocInsurance.ServiceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.ExpertiseReq;
import pocInsurance.DTORes.ExpertiseRes;
import pocInsurance.Entity.Claim;
import pocInsurance.Entity.Expertise;
import pocInsurance.Entity.ExpertP;
import pocInsurance.Entity.User;
import pocInsurance.Repository.ClaimRepository;
import pocInsurance.Repository.ExpertiseRepository;
import pocInsurance.Repository.ExpertPRepository;
import pocInsurance.Repository.UserRepository;
import pocInsurance.Service.ExpertiseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpertiseServiceImp implements ExpertiseService {

    private final ExpertiseRepository expertiseRepository;
    private final ClaimRepository claimRepository;
    private final ExpertPRepository expertPRepository;
    private final UserRepository userRepository;

    @Override
    public ExpertiseRes createExpertise(ExpertiseReq request) {
        // Ottieni lo user
        User user = userRepository.findByUsername(request.getExpertUsername())
                .orElseThrow(() -> new RuntimeException("Utente non trovato: " + request.getExpertUsername()));

        // Ottieni il perito collegato allo user
        ExpertP expert = expertPRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Perito non trovato per lo user: " + user.getUsername()));

        // Verifica che il sinistro esista
        Claim claim = claimRepository.findById(request.getClaimId())
                .orElseThrow(() -> new RuntimeException("Claim non trovato con ID: " + request.getClaimId()));

        // Verifica che non esista già una perizia per questo sinistro
        Optional<Expertise> existing = expertiseRepository.findByExpertIdAndClaimId(expert.getId(), claim.getId());
        if (existing.isPresent()) {
            throw new RuntimeException("Una perizia esiste già per questo sinistro e perito.");
        }

        Expertise expertise = new Expertise();
        expertise.setDescrizione(request.getDescription());
        expertise.setDataCreazione(LocalDate.now());
        expertise.setClaim(claim);
        expertise.setExpert(expert);

        Expertise saved = expertiseRepository.save(expertise);
        return mapToRes(saved);
    }

    @Override
    public ExpertiseRes getExpertiseById(Long id) {
        Expertise expertise = expertiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perizia non trovata con ID: " + id));
        return mapToRes(expertise);
    }

    @Override
    public List<ExpertiseRes> getExpertisesByExpertUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User non trovato: " + username));

        ExpertP expert = expertPRepository.findByUserId(user.getId())
                .orElseThrow(() -> new RuntimeException("Perito non trovato per user: " + username));

        return expertiseRepository.findByExpertId(expert.getId())
                .stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    @Override
    public ExpertiseRes getExpertiseByClaimId(Long claimId) {
        return expertiseRepository.findByClaimId(claimId)
                .map(this::mapToRes)
                .orElseThrow(() -> new RuntimeException("Perizia non trovata per claim ID: " + claimId));
    }

    @Override
    public ExpertiseRes updateExpertise(Long id, ExpertiseReq request) {
        Expertise expertise = expertiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perizia non trovata con ID: " + id));

        expertise.setDescrizione(request.getDescription());
        Expertise updated = expertiseRepository.save(expertise);
        return mapToRes(updated);
    }

    @Override
    public void deleteExpertise(Long id) {
        Expertise expertise = expertiseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perizia non trovata con ID: " + id));
        expertiseRepository.delete(expertise);
    }

    private ExpertiseRes mapToRes(Expertise expertise) {
        return ExpertiseRes.builder()
                .id(expertise.getId())
                .description(expertise.getDescrizione())
                .dataCreazione(expertise.getDataCreazione())
                .claimId(expertise.getClaim().getId())
                .expertId(expertise.getExpert().getId())
                .build();
    }
}
