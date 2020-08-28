package eva.recipes.chapter4mvc2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void foo() throws Exception {

        /*
        The test method first registers behavior on the mocked OrderService to return a single
        instance of an Order.
         */

        when(orderService.findAll())
                .thenReturn(List.of(new Order("1234", BigDecimal.TEN)));

        /*
        We use MockMvc to perform a get on the /orders endpoint.
        As this is an asynchronous controller, the reqyest should start asynchronous processing.
         */

        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/orders"))
                .andExpect(request().asyncStarted())
                .andDo(MockMvcResultHandlers.log())
                .andReturn();

        /*
        Next we mimic the asunc dispatching and write assertions for the actual response.
        The result should be a single json element containeing an id and amount.
         */

        mockMvc.perform(asyncDispatch(mvcResult))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":\"1234\",\"amount\":10}"));
    }

}