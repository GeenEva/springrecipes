package eva.recipes.chapter2calculator.calculator;

public interface Operation {

    int apply(int leftSide, int rightSide);
    boolean handles(char operator);
}
