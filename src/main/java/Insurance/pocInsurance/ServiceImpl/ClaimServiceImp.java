package pocInsurance.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.ClaimReq;
import pocInsurance.DTORes.ClaimRes;
import pocInsurance.Entity.*;
import pocInsurance.Exception.ResourceNotFoundException;
import pocInsurance.Mapper.ClaimMapper;
import pocInsurance.Repository.*;
import pocInsurance.Service.ClaimService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImp implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private InsuredRepository insuredRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private ExpertPRepository expertPRepository;

    @Autowired
    private AccountantRepository accountantRepository;

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

        // Assegnazione automatica (può essere migliorata con logica di disponibilità, zona, ecc.)
        ExpertP expert = expertPRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No available expert"));
        claim.setExpertP(expert);

        Accountant accountant = accountantRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("No available accountant"));
        claim.setAccountant(accountant);

        claimRepository.save(claim);
        return ClaimMapper.toClaimRes(claim);
    }

    @Override
    public List<ClaimRes> getAllClaims() {
        return claimRepository.findAll().stream()
                .map(ClaimMapper::toClaimRes)
                .collect(Collectors.toList());
    }

    @Override
    public ClaimRes getClaimById(Long id) {
        Claim claim = claimRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Claim not found"));
        return ClaimMapper.toClaimRes(claim);
    }
}
