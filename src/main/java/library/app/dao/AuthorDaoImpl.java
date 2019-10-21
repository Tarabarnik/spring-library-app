package library.app.dao;

import java.util.List;
import javax.persistence.TypedQuery;

import library.app.entity.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AuthorDaoImpl implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

    @Override
    public void update(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }

    @Override
    public List<Author> findByName(String name) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Author WHERE name=:name", Author.class
        );
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Author WHERE name=:name AND surname=:surname", Author.class
        );
        query.setParameter("name", name);
        query.setParameter("surname", surname);
        return query.getResultList();
    }

    @Override
    public List<Author> listAuthors() {
        TypedQuery<Author> query = sessionFactory.getCurrentSession().createQuery("FROM Author",
                Author.class);
        return query.getResultList();
    }
}
