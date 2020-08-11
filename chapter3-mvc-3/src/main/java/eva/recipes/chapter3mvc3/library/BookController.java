package eva.recipes.chapter3mvc3.library;


import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

   
    public Iterable<eva.recipes.chapter3mvc3.library.Book> list() {
        return bookService.findAll();
    }


    @GetMapping("/books.html")
    public String all(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<eva.recipes.chapter3mvc3.library.Book> getBookByIsbn(@PathVariable("isbn") String isbn){
        return bookService.find(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book, UriComponentsBuilder uriBuilder){
        Book created = bookService.create(book);
        URI newBookUri = uriBuilder.path("/books/{isbn}").build(created.getIsbn());
        return ResponseEntity.created(newBookUri).body(created);
    }
}
