package library.app.dao;

import java.util.List;
import java.util.Optional;

import library.app.entity.Book;
import library.app.entity.Rent;
import library.app.entity.User;

public interface RentDao {
    void add(Rent rent);

    Optional<Rent> get(User user, Book book);

    void update(Rent rent);

    List<Book> getBooksRentByUser(User user);

    List<Rent> listRents();
}
