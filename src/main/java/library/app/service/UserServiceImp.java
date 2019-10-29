package library.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import library.app.dao.UserDao;
import library.app.dto.UserRegistrationDto;
import library.app.entity.Role;
import library.app.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public Optional<User> get(Long id) {
        return userDao.get(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Transactional
    @Override
    public User registerNewUserAccount(UserRegistrationDto accountDto) throws Exception {
        if (emailExists(accountDto.getEmail())) {
            throw new Exception(
                    "There is an account with that email address: " + accountDto.getEmail());
        }
        User user = new User();
        user.setFirstName(accountDto.getFirstName());
        user.setLastName(accountDto.getLastName());
        user.setPassword(accountDto.getPassword());
        user.setEmail(accountDto.getEmail());
        user.setUsername(accountDto.getUsername());
        user.setRoles(Arrays.asList(new Role("USER")));
        return userDao.add(user);
    }

    private boolean emailExists(String email) {
        User user = userDao.findByEmail(email).orElse(null);
        if (user != null) {
            return true;
        }
        return false;
    }
}
