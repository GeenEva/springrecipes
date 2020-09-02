package eva.recipes.chapter6security1.library.rest;

import eva.recipes.chapter6security1.library.Book;
import eva.recipes.chapter6security1.library.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;

import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.security.user.password=s3cr3t")
public class BookControllerIntegrationWebClientTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private BookService bookService;

    @Test
    public void shouldReturnListOfBooks(){
        when(bookService.findAll())
                .thenReturn(Arrays.asList(
                        new Book("123", "123title", "Eva", "Mirte"),
                        new Book("456", "456title", "Teim", "Doortje")
                ));

        webTestClient
                .get()
                .uri("/books.html")
                .headers( headers -> headers.setBasicAuth("user", "s3cr3t"))
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Book.class).hasSize(2);
    }

}
