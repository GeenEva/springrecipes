package eva.recipes.chapter6security1.library.rest;


import eva.recipes.chapter6security1.library.Book;
import eva.recipes.chapter6security1.library.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.security.user.password=s3cr3t")
public class BookControllerIntegrationTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    private BookService bookService;

    @Test
    public void shouldReturnListOfBooks(){
        when(bookService.findAll())
                .thenReturn(Arrays.asList(
                        new Book("123", "123title", "Eva", "Mirte"),
                        new Book("456", "456title", "Teim", "Doortje")
                ));

        ResponseEntity<Book[]> books = testRestTemplate
                .withBasicAuth("user", "s3cr3t")
                .getForEntity("/books.html", Book[].class);

        assertThat(books.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(books.getBody()).hasSize(2);
    }
}
