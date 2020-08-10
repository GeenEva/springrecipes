package eva.recipes.chapter3mvc1.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloWorldController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(status().isOk())
                .andExpect(content().string("Hello world...from Spring Boot 2 !"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));

    }
}