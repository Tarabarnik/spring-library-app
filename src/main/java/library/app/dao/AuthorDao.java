package library.app.dao;

import java.util.List;

import library.app.entity.Author;

public interface AuthorDao {
    void add(Author author);

    void update(Author author);

    List<Author> findByName(String name);

    List<Author> findByNameAndSurname(String name, String surname);

    List<Author> listAuthors();
}
