package library.app.dao;

import java.util.List;

import library.app.entity.Book;

public interface BookDao {
    void add(Book book);

    void update(Book book);

    List<Book> findByTitle(String title);

    List<Book> listBooks();
}
