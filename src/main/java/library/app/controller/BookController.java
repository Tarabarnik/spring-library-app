package library.app.controller;

import java.util.List;

import library.app.entity.Book;
import library.app.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public String getAllBooks(ModelMap model) {
        model.put("books", bookService.listBooks());
        return "allBooks";
    }

    @GetMapping("/info/{id}")
    public String bookInfo(ModelMap model, @PathVariable ("id") Long id) {
        Book book = bookService.get(id).get();
        model.put("book", book);
        return "bookInfo";
    }

    @GetMapping("/find")
    public String findBook(ModelMap model, @RequestParam String title) {
        List<Book> books = bookService.findByTitle(title);
        model.put("books", books);
        return "booksSearchResult";
    }

    @GetMapping("/new")
    public String newBook() {
        return "new";
    }

    @GetMapping("/add")
    private String addBook(ModelMap model, @ModelAttribute Book book) {
        bookService.add(book);
        return getAllBooks(model);
    }
}
