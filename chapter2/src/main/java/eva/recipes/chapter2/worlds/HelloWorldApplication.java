package eva.recipes.chapter2.worlds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("eva.recipes.chapter2")
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println(ctx.getBeanDefinitionCount());

	}

}
