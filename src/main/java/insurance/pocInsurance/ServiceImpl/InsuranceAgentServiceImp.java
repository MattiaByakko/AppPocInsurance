package pocInsurance.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.InsuranceAgentReq;
import pocInsurance.DTORes.InsuranceAgentRes;
import pocInsurance.Entity.InsuranceAgent;
import pocInsurance.Entity.Role;
import pocInsurance.Entity.User;
import pocInsurance.Repository.InsuranceAgentRepository;
import pocInsurance.Repository.UserRepository;
import pocInsurance.Service.InsuranceAgentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InsuranceAgentServiceImp implements InsuranceAgentService {

    private final InsuranceAgentRepository insuranceAgentRepository;
    private final UserRepository userRepository;

    @Override
    public InsuranceAgentRes createInsuranceAgent(InsuranceAgentReq request) {
        // 1. Trova l'utente con username
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User non trovato con username: " + request.getUsername()));

        // 2. Verifica che il ruolo sia INSURANCE_AGENT
        if (!user.getRuolo().equals(Role.INSURANCE_AGENT)) {
            throw new RuntimeException("L'utente non ha ruolo INSURANCE_AGENT");
        }

        // 3. Crea il nuovo InsuranceAgent
        InsuranceAgent agent = InsuranceAgent.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .role(Role.INSURANCE_AGENT)
                .build();

        // 4. Salva l'agente
        InsuranceAgent saved = insuranceAgentRepository.save(agent);

        // 5. Ritorna il DTO di risposta
        return InsuranceAgentRes.builder()
                .id(saved.getId())
                .firstName(saved.getFirstName())
                .lastName(saved.getLastName())
                .email(saved.getEmail())
                .phoneNumber(saved.getPhoneNumber())
                .username(user.getUsername())
                .build();
    }

    @Override
    public InsuranceAgentRes getInsuranceAgentById(Long id) {
        InsuranceAgent agent = insuranceAgentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agente non trovato con ID: " + id));

        User user = userRepository.findByEmail(agent.getEmail())
                .orElse(null);

        return InsuranceAgentRes.builder()
                .id(agent.getId())
                .firstName(agent.getFirstName())
                .lastName(agent.getLastName())
                .email(agent.getEmail())
                .phoneNumber(agent.getPhoneNumber())
                .username(user != null ? user.getUsername() : null)
                .build();
    }


    @Override
    public List<InsuranceAgentRes> getAllInsuranceAgents() {
        List<InsuranceAgent> agents = insuranceAgentRepository.findAll();

        return agents.stream()
                .map(agent -> {
                    // Recupera lo user collegato (assumendo che email sia unica)
                    User user = userRepository.findByEmail(agent.getEmail())
                            .orElse(null);

                    return InsuranceAgentRes.builder()
                            .id(agent.getId())
                            .firstName(agent.getFirstName())
                            .lastName(agent.getLastName())
                            .email(agent.getEmail())
                            .phoneNumber(agent.getPhoneNumber())
                            .username(user != null ? user.getUsername() : null)
                            .build();
                })
                .toList();
    }


    @Override
    public InsuranceAgentRes getAgentByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User non trovato con username: " + username));

        InsuranceAgent agent = insuranceAgentRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("Nessun agente associato a questo username"));

        return InsuranceAgentRes.builder()
                .id(agent.getId())
                .firstName(agent.getFirstName())
                .lastName(agent.getLastName())
                .email(agent.getEmail())
                .phoneNumber(agent.getPhoneNumber())
                .username(user.getUsername())
                .build();
    }
}
