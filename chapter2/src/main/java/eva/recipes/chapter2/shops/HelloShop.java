package eva.recipes.chapter2.shops;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class HelloShop {

    @PostConstruct
    public void helloShop(){
        System.out.println("Hello shop...");
    }
}
