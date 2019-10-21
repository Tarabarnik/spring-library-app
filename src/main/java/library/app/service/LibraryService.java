package library.app.service;

import java.util.List;

import library.app.entity.Book;
import library.app.entity.Rent;
import library.app.entity.User;

public interface LibraryService {
    Rent rentBook(User user, Book book);

    void returnBook(User user, Book book);

    List<Book> getBooksRentByUser(User user);
}
