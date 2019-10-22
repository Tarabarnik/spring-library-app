package library.app.dao;

import java.util.List;
import java.util.Optional;

import library.app.entity.Book;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    List<Book> findByTitle(String title);

    Optional<Book> get(Long id);

    List<Book> listBooks();
}
