package library.app.controller;

import library.app.entity.Book;
import library.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/info")
    public String bookInfo(ModelMap model, @RequestParam Long id) {
        Book book = bookService.get(id).get();
        model.put("book", book);
        return "bookInfo";
    }
}
