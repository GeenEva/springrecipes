package eva.recipes.chapter3mvc2.library;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void shouldReturnListOfBooks() throws Exception {
        when(bookService.findAll()).thenReturn(Arrays.asList(
                new Book("123", "Spring 5 Recipes", "Marten Deinum", "Josh Long"),
                new Book("456", "Pro Spring MVC", "Marten Deinum", "Colin Yates")
                ));

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2) ))
                .andExpect(jsonPath("$[*].isbn", containsInAnyOrder("123", "456")))
                .andExpect(jsonPath("$[*].title", containsInAnyOrder("Spring 5 Recipes", "Pro Spring MVC" )));

    }

    @Test
    public void shouldReturn404WhenBookNotFound() throws Exception {

        when(bookService.find(anyString())).thenReturn(Optional.empty());

        mockMvc.perform(get("/books/123")).andExpect(status().isNotFound());
    }
}