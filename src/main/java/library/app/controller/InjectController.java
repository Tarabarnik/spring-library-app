package library.app.controller;

import java.util.List;

import library.app.entity.Book;
import library.app.entity.Role;
import library.app.entity.User;
import library.app.service.BookService;
import library.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/inject")
public class InjectController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    @GetMapping
    public String inject() {
        Book book1 = new Book("book 1", 1995, 20.5);
        Book book2 = new Book("book 2", 1998, 15D);
        Book book3 = new Book("book 3", 2005, 20.5);
        Book book4 = new Book("book 4", 1836, 4.35);

        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);
        bookService.add(book4);

        User user1 = new User("Sunil", "Bora", "suni.bora@example.com", "bora", "bora");
        User user2 = new User("David", "Miller", "david.miller@example.com", "mill", "mill");
        User user3 = new User("Sameer", "Singh", "sameer.singh@example.com", "sing", "sing");
        User user4 = new User("Paul", "Smith", "paul.smith@example.com", "paul", "paul");
        user1.setRoles(List.of(new Role("ROLE_USER")));
        userService.add(user1);
        user2.setRoles(List.of(new Role("ROLE_USER")));
        userService.add(user2);
        user3.setRoles(List.of(new Role("ROLE_USER")));
        userService.add(user3);
        user4.setRoles(List.of(new Role("ROLE_USER")));
        userService.add(user4);

        return "/";
    }
}
