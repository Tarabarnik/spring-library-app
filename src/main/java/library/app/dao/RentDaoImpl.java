package library.app.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.TypedQuery;

import library.app.entity.Book;
import library.app.entity.Rent;
import library.app.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RentDaoImpl implements RentDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Rent rent) {
        sessionFactory.getCurrentSession().save(rent);
    }

    @Override
    public Optional<Rent> get(User user, Book book) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Rent WHERE user_id=:user AND book_id=:book");
        query.setParameter("user", user.getId());
        query.setParameter("book", book.getId());
        try {
            Optional<Rent> rent = Optional.ofNullable((Rent) query.setMaxResults(1)
                    .getSingleResult());
            return rent;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public List<Book> getBooksRentByUser(User user) {
        TypedQuery<Book> query = sessionFactory.getCurrentSession().createQuery(
                "select book from Rent where user_id=:user_id", Book.class);
        query.setParameter("user_id", user.getId());
        return query.getResultList();
    }

    @Override
    public void update(Rent rent) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("UPDATE Rent SET active = false WHERE id = :id");
        query.setParameter("id", rent.getId());
        query.executeUpdate();
    }

    @Override
    public List<Rent> listRents() {
        TypedQuery<Rent> query = sessionFactory.getCurrentSession().createQuery("FROM Rent",
                Rent.class);
        return query.getResultList();
    }
}
