package library.app.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import library.app.entity.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User add(User user) {
        sessionFactory.getCurrentSession().save(user);
        return findByUsername(user.getUsername()).orElse(null);
    }

    @Override
    public Optional<User> get(Long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE id=:id", User.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE username=:username", User.class);
        query.setParameter("username", username);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE email=:email", User.class);
        query.setParameter("email", email);
        try {
            return Optional.of(query.getResultList().get(0));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User",
                User.class);
        return query.getResultList();
    }
}
