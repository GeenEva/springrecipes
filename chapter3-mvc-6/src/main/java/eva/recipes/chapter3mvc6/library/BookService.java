package eva.recipes.chapter3mvc6.library;


import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
}
