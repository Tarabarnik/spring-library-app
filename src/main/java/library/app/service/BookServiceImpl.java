package library.app.service;

import java.util.List;
import java.util.stream.Collectors;

import library.app.dao.BookDao;
import library.app.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Transactional
    @Override
    public void add(Book book) {
        bookDao.add(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> findByTitle(String title) {
        return bookDao.listBooks()
                .stream()
                .filter(b -> b.getTitle().equals(title))
                .collect(Collectors.toList());
    }
}
