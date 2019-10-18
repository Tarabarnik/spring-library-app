package library.app.service;

import java.util.List;

import library.app.entity.Book;

public interface BookService {
    void add(Book book);

    void update(Book book);

    List<Book> findByTitle(String title);
}
