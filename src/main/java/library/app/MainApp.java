package library.app;

import java.sql.SQLException;
import java.util.List;

import library.app.config.AppConfig;
import library.app.dao.BookDao;
import library.app.entity.Book;
import library.app.entity.User;
import library.app.service.UserService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        // Add Users
        userService.add(new User("Sunil", "Bora", "suni.bora@example.com"));
        userService.add(new User("David", "Miller", "david.miller@example.com"));
        userService.add(new User("Sameer", "Singh", "sameer.singh@example.com"));
        userService.add(new User("Paul", "Smith", "paul.smith@example.com"));

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookDao bookDao = context.getBean(BookDao.class);

        //Add Books
        bookDao.add(new Book("book 1", 1995, 20.5));
        bookDao.add(new Book("book 2", 1998, 15D));
        bookDao.add(new Book("book 3", 2005, 20.5));
        bookDao.add(new Book("book 4", 1836, 4.35));

        //Get Books
        List<Book> books = bookDao.listBooks();
        for (Book book: books) {
            System.out.println("Id = " + book.getId());
            System.out.println("title = " + book.getTitle());
            System.out.println("year = " + book.getYear());
            System.out.println("price = " + book.getPrice());
            System.out.println();
        }

        context.close();
    }
}
