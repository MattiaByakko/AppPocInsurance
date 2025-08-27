package pocInsurance.ServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pocInsurance.DTOReq.AccountantReq;
import pocInsurance.DTORes.AccountantRes;
import pocInsurance.Entity.Accountant;
import pocInsurance.Entity.Role;
import pocInsurance.Entity.User;
import pocInsurance.Repository.AccountantRepository;
import pocInsurance.Repository.UserRepository;
import pocInsurance.Service.AccountantService;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountantServiceImp implements AccountantService {

    private final AccountantRepository accountantRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AccountantRes createAccountant(AccountantReq request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setRuolo(Role.valueOf(request.getRole()));
        user = userRepository.save(user);

        Accountant accountant = new Accountant(
                request.getNome(),
                request.getCognome(),
                request.getCodiceFiscale(),
                user
        );

        accountant = accountantRepository.save(accountant);

        return mapToRes(accountant);
    }

    @Override
    public List<AccountantRes> getAllAccountants() {
        return accountantRepository.findAll().stream()
                .map(this::mapToRes)
                .collect(Collectors.toList());
    }

    private AccountantRes mapToRes(Accountant accountant) {
        return AccountantRes.builder()
                .id(accountant.getId())
                .nome(accountant.getNome())
                .cognome(accountant.getCognome())
                .codiceFiscale(accountant.getCodiceFiscale())
                .username(accountant.getUser().getUsername())
                .role(accountant.getUser().getRuolo().name()) // <- mappaggio ruolo
                .build();
    }
}
