package pocInsurance.ServiceImpl;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.CompensationReq;
import pocInsurance.DTORes.CompensationRes;
import pocInsurance.Entity.*;
import pocInsurance.Exception.ResourceNotFoundException;
import pocInsurance.Mapper.CompensationMapper;
import pocInsurance.Repository.AccountantRepository;
import pocInsurance.Repository.ClaimRepository;
import pocInsurance.Repository.CompensationRepository;
import pocInsurance.Service.CompensationService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompensationServiceImp implements CompensationService {

    @Autowired
    private CompensationRepository compensationRepository;

    @Autowired
    private AccountantRepository accountantRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private CompensationMapper compensationMapper;

    @Override
    @Transactional
    public CompensationRes createCompensation(CompensationReq request) {
        // Trova il contabile autenticato
        Accountant accountant = accountantRepository.findByUserUsername(request.getAccountantUsername())
                .orElseThrow(() -> new ResourceNotFoundException("Accountant non trovato con username: " + request.getAccountantUsername()));

        // Trova il sinistro
        Claim claim = claimRepository.findById(request.getClaimId())
                .orElseThrow(() -> new ResourceNotFoundException("Claim non trovato con ID: " + request.getClaimId()));

        // Verifica che non esista già una compensazione per questo sinistro
        Optional<Compensation> existingComp = compensationRepository.findByClaimId(request.getClaimId());
        if (existingComp.isPresent()) {
            throw new IllegalStateException("Esiste già una compensazione per questo sinistro.");
        }

        // Crea la nuova compensazione
        Compensation compensation = new Compensation();
        compensation.setImportoStimato(request.getImportoStimato());
        compensation.setMassimale(request.getMassimale());
        compensation.setStato(CompensationState.IN_VALUTAZIONE);
        compensation.setAccountant(accountant);
        compensation.setClaim(claim);

        // Salva e restituisce
        Compensation saved = compensationRepository.save(compensation);
        return compensationMapper.toDto(saved);
    }

    @Override
    public CompensationRes getCompensationByClaimId(Long claimId) {
        Compensation compensation = compensationRepository.findByClaimId(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Compensation not found for claim ID: " + claimId));

        return compensationMapper.toDto(compensation);
    }


    @Override
    public List<CompensationRes> getAllCompensations() {
        return compensationRepository.findAll()
                .stream()
                .map(compensationMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CompensationRes getCompensationById(Long id) {
        Compensation comp = compensationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compensazione non trovata con ID: " + id));
        return compensationMapper.toDto(comp);
    }
}
