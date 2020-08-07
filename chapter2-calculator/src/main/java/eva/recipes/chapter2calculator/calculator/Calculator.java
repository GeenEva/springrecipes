package eva.recipes.chapter2calculator.calculator;

import org.springframework.stereotype.Component;
import java.util.Collection;

@Component
public class Calculator {

    private final Collection<Operation> operations;

    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }

    public void calculate(int leftSide, int rightSide, char operator){
        for (var operation : operations){
            if(operation.handles(operator)){
                var result = operation.apply(leftSide, rightSide);
                System.out.printf("%d %s %d = %d%n", leftSide, operator, rightSide, result);
                return;
            }
        } throw new IllegalArgumentException("Unknown operation...");
    }
}
