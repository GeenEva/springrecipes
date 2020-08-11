package eva.recipes.chapter3mvc3.library;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
    public String all(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping(value = "/books", params = "isbn")
    public String getByIsbn(@RequestParam("isbn") String isbn, Model model){
        bookService.find(isbn)
                .ifPresent(book -> model.addAttribute("book", book));
        return "/books/details";
    }

}
