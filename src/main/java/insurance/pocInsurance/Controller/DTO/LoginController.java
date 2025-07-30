/*package pocInsurance.Controller.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pocInsurance.DTOReq.LoginReq;
import pocInsurance.DTORes.LoginRes;
import pocInsurance.Entity.User;
import pocInsurance.Repository.UserRepository;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginReq request) {
        Optional<User> optionalUser = userRepository.findByUsername(request.getUsername());

        if (optionalUser.isEmpty()) {
            return ResponseEntity.status(401).body("Username non trovato.");
        }

        User user = optionalUser.get();
        if (!user.getPassword().equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Password errata.");
        }

        LoginRes response = new LoginRes(user.getUsername(), user.getRuolo());
        return ResponseEntity.ok(response);
    }
}
*/