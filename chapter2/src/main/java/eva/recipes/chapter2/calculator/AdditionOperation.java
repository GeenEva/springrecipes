package eva.recipes.chapter2.calculator;

public class AdditionOperation implements Operation{

    private final char operator;

    public AdditionOperation(char operator) {
        this.operator = operator;
    }

    @Override
    public int apply(int leftSide, int rightSide) {
        return leftSide + rightSide;
    }

    @Override
    public boolean handles(char operator) {
        return this.operator == operator;
    }
}
