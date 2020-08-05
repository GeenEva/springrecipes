package eva.recipes.chapter2;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloWorld {

    @PostConstruct
    public void sayHello(){
        System.out.println("Hello world...");
    }
}
