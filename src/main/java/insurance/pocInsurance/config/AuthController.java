package pocInsurance.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pocInsurance.config.AppUserInfo;

@RestController
public class AuthController {

    private final CurrentUserHelper currentUserHelper;

    public AuthController(CurrentUserHelper currentUserHelper) {
        this.currentUserHelper = currentUserHelper;
    }


    @GetMapping("/api/me")
    public AppUserInfo getCurrentUser() {
        return currentUserHelper.requireUser();
    }
}
