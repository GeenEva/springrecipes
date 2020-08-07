package eva.recipes.chapter2.calculator;

public class AdditionOperation implements Operation{

    @Override
    public int apply(int leftSide, int rightSide) {
        return leftSide + rightSide;
    }

    @Override
    public boolean handles(char operator) {
        return '+' == operator;
    }
}
