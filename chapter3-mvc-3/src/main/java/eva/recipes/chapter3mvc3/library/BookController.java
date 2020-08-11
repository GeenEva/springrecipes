package eva.recipes.chapter3mvc3.library;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
