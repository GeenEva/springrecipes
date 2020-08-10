package eva.recipes.chapter3mvc2;

import eva.recipes.chapter3mvc2.library.Book;
import eva.recipes.chapter3mvc2.library.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);
	}

	public ApplicationRunner booksInitializer(BookService bookService){
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}

}
