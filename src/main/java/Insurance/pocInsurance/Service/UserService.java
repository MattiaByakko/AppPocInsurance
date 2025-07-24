package pocInsurance.Service;



import pocInsurance.Entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<User> findByUsername(String username);

    User saveUser(User user);
    Optional<User> getUserById(Long id);
    List<User> getAllUsers();
    void deleteUserById(Long id);
}
