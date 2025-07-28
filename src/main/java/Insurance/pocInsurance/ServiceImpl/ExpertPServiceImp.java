package pocInsurance.ServiceImpl;

import pocInsurance.DTOReq.ExpertPReq;
import pocInsurance.DTORes.ExpertPRes;
import pocInsurance.Entity.ExpertP;
import pocInsurance.Entity.User;
import pocInsurance.Entity.Role;
import pocInsurance.Repository.ExpertPRepository;
import pocInsurance.Repository.UserRepository;
import pocInsurance.Service.ExpertPService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpertPServiceImp implements ExpertPService {

    @Autowired
    private ExpertPRepository expertPRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ExpertPRes createExpert(ExpertPReq req) {
        // Creazione utente
        User user = new User();
        user.setUsername(req.getUsername());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        user.setRuolo(Role.EXPERTP);
        userRepository.save(user);

        // Creazione ExpertP
        ExpertP expert = new ExpertP();
        expert.setNome(req.getNome());
        expert.setCognome(req.getCognome());
        expert.setCodiceFiscale(req.getCodiceFiscale());
        expert.setZonaDiCompetenza(req.getZonaDiCompetenza());
        expert.setUser(user);

        ExpertP saved = expertPRepository.save(expert);

        return ExpertPRes.builder()
                .id(saved.getId())
                .nome(saved.getNome())
                .cognome(saved.getCognome())
                .codiceFiscale(saved.getCodiceFiscale())
                .zonaDiCompetenza(saved.getZonaDiCompetenza())
                .username(user.getUsername())
                .build();
    }

    @Override
    public ExpertPRes getExpertById(Long id) {
        ExpertP expert = expertPRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expert not found with ID: " + id));

        return ExpertPRes.builder()
                .id(expert.getId())
                .nome(expert.getNome())
                .cognome(expert.getCognome())
                .codiceFiscale(expert.getCodiceFiscale())
                .zonaDiCompetenza(expert.getZonaDiCompetenza())
                .username(expert.getUser().getUsername())
                .build();
    }

    @Override
    public List<ExpertPRes> getAllExperts() {
        return expertPRepository.findAll().stream().map(expert ->
                ExpertPRes.builder()
                        .id(expert.getId())
                        .nome(expert.getNome())
                        .cognome(expert.getCognome())
                        .codiceFiscale(expert.getCodiceFiscale())
                        .zonaDiCompetenza(expert.getZonaDiCompetenza())
                        .username(expert.getUser().getUsername())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public void deleteExpert(Long id) {
        expertPRepository.deleteById(id);
    }
    private ExpertPRes mapToRes(ExpertP expertP) {
        return ExpertPRes.builder()
                .id(expertP.getId())
                .nome(expertP.getNome())
                .cognome(expertP.getCognome())
                .codiceFiscale(expertP.getCodiceFiscale())
                .zonaDiCompetenza(expertP.getZonaDiCompetenza())
                .build();
    }

    @Override
    public List<ExpertPRes> getExpertsByZona(String zona) {
        List<ExpertP> experts = expertPRepository.findByZonaDiCompetenza(zona);
        return experts.stream().map(this::mapToRes).toList();
    }

}
