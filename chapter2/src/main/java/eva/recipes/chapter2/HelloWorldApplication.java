package eva.recipes.chapter2;

import eva.recipes.chapter2.calculator.AdditionOperation;
import eva.recipes.chapter2.calculator.Calculator;
import eva.recipes.chapter2.calculator.Operation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@ComponentScan("eva.recipes.chapter2")
@SpringBootApplication
public class HelloWorldApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext ctx = SpringApplication.run(HelloWorldApplication.class, args);
		System.out.println(ctx.getBeanDefinitionCount());

		Collection<Operation> operations = null;
		operations.add(new AdditionOperation('+'));
		operations.
		Calculator calculator = new Calculator(operations);

	}

}
