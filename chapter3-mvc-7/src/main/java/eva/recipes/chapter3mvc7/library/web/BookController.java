package eva.recipes.chapter3mvc7.library.web;

import eva.recipes.chapter3mvc7.library.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Book;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books.html")
    public String all(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping(value = "/books.html", params = "isbn")
    public String getByIsbn(@RequestParam("isbn") String isbn, Model model){

        bookService.find(isbn)
                .ifPresent(book -> model.addAttribute("book", book));
        return "/books/details";
    }

    @PostMapping("/books")
    public Book create(@ModelAttribute Book book){

        return bookService.create(book);

    }
}
