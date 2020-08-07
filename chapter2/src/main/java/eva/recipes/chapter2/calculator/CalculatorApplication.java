package eva.recipes.chapter2.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {
        var ctx = SpringApplication.run(CalculatorApplication.class, args);

        var calculator = ctx.getBean(Calculator.class);

        calculator.calculate(25, 2, '+');
        calculator.calculate(25, 2, '*');
        calculator.calculate(25, 2, '-');
    }

    @Bean
    Calculator getCalculator(Collection<Operation> operations){
        return new Calculator(operations);
    }
}
