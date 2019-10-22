package library.app.service;

import java.util.List;
import java.util.Optional;

import library.app.entity.Book;

public interface BookService {
    void add(Book book);

    void update(Book book);

    Optional<Book> get(Long id);

    List<Book> listBooks();

    List<Book> findByTitle(String title);
}
