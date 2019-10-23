package library.app.service;

import java.time.LocalDate;
import java.util.List;

import library.app.dao.RentDao;
import library.app.entity.Book;
import library.app.entity.Rent;
import library.app.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private RentDao rentDao;

    @Transactional
    @Override
    public Rent rentBook(User user, Book book) {
        Rent rent = new Rent(LocalDate.now(), user, book, true);
        rentDao.add(rent);
        return rentDao.get(user, book).get();
    }

    @Transactional
    @Override
    public void returnBook(User user, Book book) {
        Rent rent = rentDao.get(user, book).get();
        rent.setActive(false);
        rentDao.update(rent);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> getBooksRentByUser(User user) {
        return rentDao.getBooksRentByUser(user);
    }
}
