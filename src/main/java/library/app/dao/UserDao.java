package library.app.dao;

import library.app.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();
}
