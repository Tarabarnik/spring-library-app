package library.app.service;

import java.util.List;
import java.util.stream.Collectors;

import library.app.dao.AuthorDao;
import library.app.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Transactional
    @Override
    public void add(Author author) {
        authorDao.add(author);
    }

    @Override
    public void update(Author author) {
        authorDao.update(author);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByName(String name) {
        return authorDao.listAuthors()
                .stream()
                .filter(a -> a.getName().equals(name))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Author> findByNameAndSurname(String name, String surname) {
        return findByName(name)
                .stream()
                .filter(a -> a.getSurname().equals(surname))
                .collect(Collectors.toList());
    }
}
