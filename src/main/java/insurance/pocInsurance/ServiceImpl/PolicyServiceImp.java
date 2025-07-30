package pocInsurance.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.PolicyReq;
import pocInsurance.DTORes.PolicyRes;
import pocInsurance.Entity.Policy;
import pocInsurance.Entity.User;
import pocInsurance.Entity.Vehicle;
import pocInsurance.Repository.PolicyRepository;
import pocInsurance.Repository.UserRepository;
import pocInsurance.Repository.VehicleRepository;
import pocInsurance.Service.PolicyService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PolicyServiceImp implements PolicyService {

    private final PolicyRepository policyRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    @Override
    public PolicyRes createPolicy(PolicyReq request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("Utente non trovato con ID: " + request.getUserId()));

        Vehicle vehicle = vehicleRepository.findById(request.getVehicleId())
                .orElseThrow(() -> new RuntimeException("Veicolo non trovato con ID: " + request.getVehicleId()));

        Policy policy = new Policy();
        policy.setNumeroPolizza(request.getNumeroPolizza());
        policy.setDataInizio(LocalDate.parse(request.getDataInizio()));
        policy.setDataFine(LocalDate.parse(request.getDataFine()));
        policy.setUser(user);
        policy.setVehicle(vehicle);

        Policy saved = policyRepository.save(policy);

        return mapToRes(saved);
    }

    @Override
    public PolicyRes getPolicyByVehicleId(Long vehicleId) {
        Policy policy = policyRepository.findByVehicleId(vehicleId)
                .orElseThrow(() -> new RuntimeException("Polizza non trovata per il veicolo con ID: " + vehicleId));

        return mapToRes(policy);
    }


    @Override
    public List<PolicyRes> getAllPolicies() {
        return policyRepository.findAll()
                .stream()
                .map(this::mapToRes)
                .toList();
    }

    @Override
    public List<PolicyRes> getPoliciesByUserId(Long userId) {
        Optional<Policy> policies = policyRepository.findByUserId(userId);
        return policies.stream()
                .map(this::mapToRes)
                .toList();
    }



    private PolicyRes mapToRes(Policy policy) {
        return PolicyRes.builder()
                .id(policy.getId())
                .numeroPolizza(policy.getNumeroPolizza())
                .dataInizio(policy.getDataInizio().toString())
                .dataFine(policy.getDataFine().toString())
                .userId(policy.getUser().getId())
                .vehicleId(policy.getVehicle().getId())
                .build();
    }
    @Override
    public PolicyRes getPolicyById(Long id) {
        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Polizza non trovata con ID: " + id));
        return mapToRes(policy);
    }
}
