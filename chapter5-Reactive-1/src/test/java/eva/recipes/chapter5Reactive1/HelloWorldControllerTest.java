package eva.recipes.chapter5Reactive1;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class HelloWorldControllerTest {

    private final HelloWorldController controller = new HelloWorldController();

    @Test
    public void shouldSayHello(){
        Mono<String> result = controller.hello();

        StepVerifier.create(result)
                .expectNext("Hello World, from Reactive Spering Boot2!")
                .verifyComplete();
    }

}