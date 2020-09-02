package eva.recipes.chapter6security1.library.rest;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;

@WebMvcTest(BookController.class)
@WithMockUser
public class BookControllerSecuredTest {

}
