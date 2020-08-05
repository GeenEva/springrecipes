package eva.recipes.chapter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Chapter2Application {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(Chapter2Application.class, args);
		System.out.println(ctx.getBeanDefinitionCount());

	}

}
