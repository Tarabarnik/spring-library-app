package library.app.dao;

import java.util.List;
import java.util.Optional;

import library.app.entity.User;

public interface UserDao {
    void add(User user);

    Optional<User> get(Long id);

    List<User> listUsers();
}
