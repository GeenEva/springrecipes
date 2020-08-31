package eva.recipes.chapter5Reactive1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {


    @GetMapping("/hello")
    public Mono<String> hello(){
        return Mono.just("Hello World, from Reactive Spering Boot2!");
    }

}