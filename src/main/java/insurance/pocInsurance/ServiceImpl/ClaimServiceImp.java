package pocInsurance.ServiceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.Entity.*;
import pocInsurance.Exception.ResourceNotFoundException;
import pocInsurance.Mapper.ClaimMapper;
import pocInsurance.Repository.*;
import pocInsurance.Service.ClaimService;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class ClaimServiceImp implements ClaimService {

    private final ClaimRepository claimRepository;
    private final InsuredRepository insuredRepository;
    private final VehicleRepository vehicleRepository;
    private final PolicyRepository policyRepository;
    private final ExpertPRepository expertPRepository;
    private final AccountantRepository accountantRepository;
    private final CounterpartRepository counterpartRepository;

    public ClaimServiceImp(ClaimRepository claimRepository,
                           InsuredRepository insuredRepository,
                           VehicleRepository vehicleRepository,
                           PolicyRepository policyRepository,
                           ExpertPRepository expertPRepository,
                           AccountantRepository accountantRepository,
                           CounterpartRepository counterpartRepository) {
        this.claimRepository = claimRepository;
        this.insuredRepository = insuredRepository;
        this.vehicleRepository = vehicleRepository;
        this.policyRepository = policyRepository;
        this.expertPRepository = expertPRepository;
        this.accountantRepository = accountantRepository;
        this.counterpartRepository = counterpartRepository;
    }

    @Override
    public ClaimRes createClaim(ClaimReq request) {
        Claim claim = ClaimMapper.toClaim(request);

        // Associazioni obbligatorie
        claim.setInsured(insuredRepository.findById(request.getInsuredId())
                .orElseThrow(() -> new ResourceNotFoundException("Insured not found")));

        claim.setVeicolo(vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found")));

        claim.setPolicy(policyRepository.findById(request.getPolicyId())
                .orElseThrow(() -> new ResourceNotFoundException("Policy not found")));

        // Assegno perito in base alla zona
        List<ExpertP> expertInZona = expertPRepository.findByZonaDiCompetenza(request.getZone());
        if (expertInZona.isEmpty()) {
            throw new ResourceNotFoundException("Nessun perito disponibile nella zona: " + request.getZone());
        }
        ExpertP peritoAssegnato = expertInZona.get(new Random().nextInt(expertInZona.size()));
        claim.setExpertP(peritoAssegnato);

        // Assegno accountant (primo disponibile)
        Accountant accountant = accountantRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No available accountant"));
        claim.setAccountant(accountant);

        // Gestione counterpart
        if (request.getCounterpartId() != null) {
            claim.setCounterpart(counterpartRepository.findById(request.getCounterpartId())
                    .orElseThrow(() -> new ResourceNotFoundException("Counterpart not found")));
        } else if (request.getCounterpartNome() != null) {
            Counterpart newCounterpart = new Counterpart();
            newCounterpart.setNome(request.getCounterpartNome());
            newCounterpart.setCognome(request.getCounterpartCognome());
            newCounterpart.setCodiceFiscale(request.getCounterpartCodiceFiscale());
            newCounterpart.setIndirizzo(request.getCounterpartIndirizzo());

            Counterpart saved = counterpartRepository.save(newCounterpart);
            claim.setCounterpart(saved);
        }

        claimRepository.save(claim);
        return ClaimMapper.toClaimRes(claim);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaimRes> getAllClaims() {
        return claimRepository.findAll().stream()
                .map(ClaimMapper::toClaimRes)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ClaimRes getClaimById(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id " + id));
        return ClaimMapper.toClaimRes(claim);
    }

    @Override
    public ClaimRes updateClaimState(Long claimId, State nuovoStato) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id " + claimId));
        claim.setState(nuovoStato);
        Claim updated = claimRepository.save(claim);
        return ClaimMapper.toClaimRes(updated);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClaimRes> getClaimsByInsuredId(Long insuredId) {
        return claimRepository.findByInsuredId(insuredId).stream()
                .map(ClaimMapper::toClaimRes)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimRes updateClaim(Long claimId, ClaimReq request) {
        Claim claim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found with id " + claimId));

        // Aggiorno campi di base
        claim.setDescrizione(request.getDescrizione());
        claim.setZone(request.getZone());

        if (request.getDataEvento() != null && !request.getDataEvento().isBlank()) {
            claim.setDataApertura(LocalDate.parse(request.getDataEvento()));
        }

        // Aggiorno Insured
        if (request.getInsuredId() != null) {
            claim.setInsured(insuredRepository.findById(request.getInsuredId())
                    .orElseThrow(() -> new ResourceNotFoundException("Insured not found")));
        }

        // Aggiorno Vehicle
        if (request.getVehicleId() != null) {
            claim.setVeicolo(vehicleRepository.findById(request.getVehicleId())
                    .orElseThrow(() -> new ResourceNotFoundException("Vehicle not found")));
        }

        // Aggiorno Policy
        if (request.getPolicyId() != null) {
            claim.setPolicy(policyRepository.findById(request.getPolicyId())
                    .orElseThrow(() -> new ResourceNotFoundException("Policy not found")));
        }

        // Aggiorno Expert
        if (request.getExpertId() != null) {
            claim.setExpertP(expertPRepository.findById(request.getExpertId())
                    .orElseThrow(() -> new ResourceNotFoundException("Expert not found")));
        }

        // Aggiorno Accountant
        if (request.getAccountantId() != null) {
            claim.setAccountant(accountantRepository.findById(request.getAccountantId())
                    .orElseThrow(() -> new ResourceNotFoundException("Accountant not found")));
        }

        // Aggiorno o creo Counterpart
        if (request.getCounterpartId() != null) {
            claim.setCounterpart(counterpartRepository.findById(request.getCounterpartId())
                    .orElseThrow(() -> new ResourceNotFoundException("Counterpart not found")));
        } else if (request.getCounterpartNome() != null) {
            Counterpart newCounterpart = new Counterpart();
            newCounterpart.setNome(request.getCounterpartNome());
            newCounterpart.setCognome(request.getCounterpartCognome());
            newCounterpart.setCodiceFiscale(request.getCounterpartCodiceFiscale());
            newCounterpart.setIndirizzo(request.getCounterpartIndirizzo());
            Counterpart saved = counterpartRepository.save(newCounterpart);
            claim.setCounterpart(saved);
        }

        // Aggiorno lo stato
        if (request.getState() != null) {
            claim.setState(State.valueOf(request.getState()));
        }

        Claim updated = claimRepository.save(claim);
        return ClaimMapper.toClaimRes(updated);
    }
}
