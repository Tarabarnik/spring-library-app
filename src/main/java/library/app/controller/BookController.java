package library.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping
    public String getAllBooks() {
        return "allBooks";
    }

    @GetMapping("/info")
    public String bookInfo() {
        return "bookInfo";
    }
}