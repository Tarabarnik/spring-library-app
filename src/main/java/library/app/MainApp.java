package library.app;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import library.app.config.AppConfig;
import library.app.dao.RentDao;
import library.app.entity.Author;
import library.app.entity.Book;
import library.app.entity.Rent;
import library.app.entity.User;
import library.app.service.AuthorService;
import library.app.service.BookService;
import library.app.service.LibraryService;
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
        System.out.println(userService.get(1L).get().getFirstName());

        // Get Users
        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        BookService bookService = context.getBean(BookService.class);

        Book book1 = new Book("book 1", 1995, 20.5);
        Book book2 = new Book("book 2", 1998, 15D);
        Book book3 = new Book("book 3", 2005, 20.5);
        Book book4 = new Book("book 4", 1836, 4.35);

        //Add Books
        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);
        bookService.add(book4);

        //Get Books
        List<Book> books = bookService.findByTitle("book 2");
        for (Book book: books) {
            System.out.println("Id = " + book.getId());
            System.out.println("title = " + book.getTitle());
            System.out.println("year = " + book.getYear());
            System.out.println("price = " + book.getPrice());
            System.out.println();
        }

        AuthorService authorService = context.getBean(AuthorService.class);

        Author author1 = new Author("Lesya", "Ukrainka");
        Author author2 = new Author("Lesya", "Voronina");
        Author author3 = new Author("Ivan", "Franko");
        Author author4 = new Author("Mihailo", "Kotsubinsky");

        book1.addAuthor(author1);
        book2.addAuthor(author1);
        book2.addAuthor(author2);
        book3.addAuthor(author3);
        book4.addAuthor(author4);

        author1.addBook(book1);
        author1.addBook(book2);
        author2.addBook(book2);
        author3.addBook(book3);
        author4.addBook(book4);

        authorService.add(author1);
        authorService.add(author2);
        authorService.add(author3);
        authorService.add(author4);

        List<Author> authors = authorService.findByName("Lesya");
        for (Author author : authors) {
            System.out.println("Id = " + author.getId());
            System.out.println("First Name = " + author.getName());
            System.out.println("Last Name = " + author.getSurname());
            System.out.println("Has " + author.getBooks().size() + " books");
            System.out.println();
        }

        List<Author> authors1 = authorService.findByNameAndSurname("Lesya", "Ukrainka");
        for (Author author : authors1) {
            System.out.println("Id = " + author.getId());
            System.out.println("First Name = " + author.getName());
            System.out.println("Last Name = " + author.getSurname());
            for (Book book: author.getBooks()) {
                System.out.println("Id = " + book.getId());
                System.out.println("title = " + book.getTitle());
                System.out.println("year = " + book.getYear());
                System.out.println("price = " + book.getPrice());
                System.out.println();
            }
            System.out.println();
        }

        RentDao rentDao = context.getBean(RentDao.class);

        rentDao.add(new Rent(LocalDate.now(), users.get(0), book1, true));
        rentDao.add(new Rent(LocalDate.now(), users.get(1), book2, true));

        Rent rent = rentDao.get(users.get(0), book1).orElse(null);
        System.out.println("Id = " + rent.getId());
        System.out.println("Book title = " + rent.getBook().getTitle());
        System.out.println();

        List<Rent> rents = rentDao.listRents();
        for (Rent r : rents) {
            System.out.println("Id = " + r.getId());
            System.out.println("Book title = " + r.getBook().getTitle());
            System.out.println();
        }

        rentDao.update(rent);

        LibraryService libraryService = context.getBean(LibraryService.class);

        System.out.println("User 1 rent " + libraryService.getBooksRentByUser(users.get(0)).size()
                + " books");

        context.close();
    }
}
