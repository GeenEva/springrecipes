package eva.recipes.chapter3mvc3;

import eva.recipes.chapter3mvc3.library.Book;
import eva.recipes.chapter3mvc3.library.BookService;
import eva.recipes.chapter3mvc3.library.CustomizedErrorAttributes;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {

		SpringApplication.run(LibraryApplication.class, args);
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService){
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}

	@Bean
	public CustomizedErrorAttributes errorAttributes(){
		return new CustomizedErrorAttributes();
	}

}
