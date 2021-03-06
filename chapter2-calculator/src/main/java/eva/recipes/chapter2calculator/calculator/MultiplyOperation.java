package eva.recipes.chapter2calculator.calculator;

import org.springframework.stereotype.Component;

@Component
public class MultiplyOperation implements Operation {

    @Override
    public int apply(int leftSide, int rightSide) {
        return leftSide * rightSide;
    }

    @Override
    public boolean handles(char operator) {
        return '*' == operator;
    }
}
