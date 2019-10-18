package library.app.service;

import java.util.List;

import library.app.entity.Author;

public interface AuthorService {
    void add(Author author);

    void update(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);
}
