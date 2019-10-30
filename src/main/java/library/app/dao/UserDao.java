package library.app.dao;

import java.util.List;
import java.util.Optional;

import library.app.entity.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    List<User> listUsers();
}
