package library.app.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import library.app.entity.Book;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Override
    public void update(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Override
    public List<Book> findByTitle(String title) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Book WHERE title LIKE CONCAT('%s', :title, '%s')", Book.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

    @Override
    public Optional<Book> get(Long id) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery(
                "FROM Book WHERE id=:id", Book.class);
        query.setParameter("id", id);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Book> listBooks() {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery("FROM Book",
                Book.class);
        return query.getResultList();
    }
}
