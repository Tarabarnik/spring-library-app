package library.app.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

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

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private UserService userService;
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private BookService bookService;

    @GetMapping("/getbook")
    public String rentBook(ModelMap model, @RequestParam(name = "book_id") Long bookId,
                           Principal principal) {
        User user = userService.getByEmail(principal.getName()).get();
        Book book = bookService.get(bookId).get();
        libraryService.rentBook(user, book);
        return userRents(model, principal);
    }

    @GetMapping("/userRents")
    public String userRents(ModelMap model, Principal principal) {
        User user = userService.getByEmail(principal.getName()).get();
        List<Book> books = libraryService.getBooksRentByUser(user);
        model.put("books", books);
        return "userRents";
    }

    @GetMapping("/returnbook")
    public String returnBook(@RequestParam(name = "book_id") Long bookId, Principal principal) {
        Optional<User> user = userService.getByEmail(principal.getName());
        Optional<Book> book = bookService.get(bookId);
        libraryService.returnBook(user.get(), book.get());
        return "allBooks";
    }
}
