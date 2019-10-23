package library.app.controller;

import library.app.entity.Book;
import library.app.entity.User;
import library.app.service.BookService;
import library.app.service.LibraryService;
import library.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rent")
public class RentController {

    private static final Long USER_ID = 1L;
    @Autowired
    private UserService userService;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private BookService bookService;

    @GetMapping("/getbook")
    public String rentBook(ModelMap model, @RequestParam(name = "book_id") Long bookId) {
        User user = userService.get(USER_ID).get();
        Book book = bookService.get(bookId).get();
        libraryService.rentBook(user, book);
        return userRents(model);
    }

    @GetMapping("/userRents")
    public String userRents(ModelMap model) {
        User user = userService.get(USER_ID).get();
        List<Book> books = libraryService.getBooksRentByUser(user);
        model.put("books", books);
        return "userRents";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam(name = "book_id") Long bookId) {
        Optional<User> user = userService.get(USER_ID);
        Optional<Book> book = bookService.get(bookId);
        libraryService.returnBook(user.get(), book.get());
        return "allBooks";
    }
}
