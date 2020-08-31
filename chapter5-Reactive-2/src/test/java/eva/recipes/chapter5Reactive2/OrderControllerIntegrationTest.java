package eva.recipes.chapter5Reactive2;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureWebTestClient
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class OrderControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void listOrder(){
        webTestClient.get().uri("/orders")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Order.class).hasSize(25);
    }

    @Test
    public void addAndGetOrders(){
        var order = new Order("test1", BigDecimal.valueOf(123.45));

        webTestClient.post().uri("/orders").syncBody(order)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Order.class).isEqualTo(order);

        webTestClient.get().uri("/orders/{id}", order.getId())
                .exchange()
                .expectStatus().isOk()
                .expectBody(Order.class).isEqualTo(order);

    }
}
