package Service;

import Entity.User;
import Entity.Role;
import Repository.UserRepository;
import Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    User createUser(User user, List<String> roleNames);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    void assignRolesToUser(Long userId, List<String> roleNames);
}
