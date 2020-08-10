package eva.recipes.chapter3mvc1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello(){
        return "Hello world...from Spring Boot 2 !";
    }
}
