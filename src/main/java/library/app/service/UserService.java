package library.app.service;

import java.util.List;
import java.util.Optional;

import library.app.dto.UserRegistrationDto;
import library.app.entity.User;

public interface UserService {
    void add(User user);

    Optional<User> get(Long id);

    List<User> listUsers();

    Optional<User> getByEmail(String email);

    User registerNewUserAccount(UserRegistrationDto accountDto)
            throws Exception;
}
