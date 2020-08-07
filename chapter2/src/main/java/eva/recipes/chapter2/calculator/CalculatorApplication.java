package eva.recipes.chapter2.calculator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(CalculatorApplication.class, args);
    }

    @Bean
    public ApplicationRunner calculationRunner(Calculator calculator,
                                               @Value("${leftSide}") int leftSide,
                                               @Value ("${rightSide}") int rightSide,
                                               @Value("${operator}") char operator){
        return args -> calculator.calculate(leftSide, rightSide, operator);
    }
}
