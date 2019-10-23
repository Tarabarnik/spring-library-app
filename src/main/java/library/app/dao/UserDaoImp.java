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
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public Optional<User> get(Long id) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery(
                "FROM User WHERE id=:id", User.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM User",
                User.class);
        return query.getResultList();
    }
}
