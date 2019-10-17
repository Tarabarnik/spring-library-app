package library.app.service;

import java.util.List;

import library.app.entity.User;

public interface UserService {
    void add(User user);

    List<User> listUsers();
}
