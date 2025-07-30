package pocInsurance.ServiceImpl;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.InsuredReq;
import pocInsurance.DTORes.InsuredRes;
import pocInsurance.Entity.Insured;
import pocInsurance.Entity.Role;
import pocInsurance.Entity.User;
import pocInsurance.Exception.ResourceNotFoundException;
import pocInsurance.Mapper.InsuredMapper;
import pocInsurance.Repository.InsuredRepository;
import pocInsurance.Repository.UserRepository;
import pocInsurance.Service.InsuredService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuredServiceImp implements InsuredService {

    private final InsuredRepository insuredRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final InsuredMapper insuredMapper;

    public InsuredServiceImp(
            InsuredRepository insuredRepository,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            InsuredMapper insuredMapper
    ) {
        this.insuredRepository = insuredRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.insuredMapper = insuredMapper;
    }

    @Override
    public InsuredRes createInsured(InsuredReq request) {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("Username già esistente");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRuolo(Role.valueOf(request.getRuolo()));
        userRepository.save(user);

        Insured insured = new Insured();
        insured.setNome(request.getNome());
        insured.setCognome(request.getCognome());
        insured.setCodiceFiscale(request.getCodiceFiscale());
        insured.setIndirizzo(request.getIndirizzo());
        insured.setUser(user);

        Insured saved = insuredRepository.save(insured);
        return insuredMapper.toRes(saved);
    }

    @Override
    public List<InsuredRes> getAllInsured() {
        return insuredRepository.findAll()
                .stream()
                .map(insuredMapper::toRes)
                .collect(Collectors.toList());
    }

    @Override
    public InsuredRes getInsuredById(Long id) {
        Insured insured = insuredRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Insured non trovato con ID: " + id));
        return insuredMapper.toRes(insured);
    }
}
