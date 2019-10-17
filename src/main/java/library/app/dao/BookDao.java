package library.app.dao;

import java.util.List;

import library.app.entity.Book;

public interface BookDao {
    void add(Book book);

    List<Book> listBooks();
}
