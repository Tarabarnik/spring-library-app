package library.app.dao;

import java.util.List;

import library.app.entity.User;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
