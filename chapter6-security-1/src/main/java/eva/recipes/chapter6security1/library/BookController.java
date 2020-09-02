package eva.recipes.chapter6security1.library;


import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public Iterable<Book> list() {

        return bookService.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") String isbn){
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
