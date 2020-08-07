package eva.recipes.chapter2calculator.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MultiplyOperationTest {

    private final MultiplyOperation multiplyOperation = new MultiplyOperation();

    @Test
    void shouldMatchOperation() {
        assertThat(multiplyOperation.handles('*')).isTrue();
        assertThat(multiplyOperation.handles('/')).isFalse();
    }

    @Test
    void shouldCorrectlyApplyFormula() {
        assertThat(multiplyOperation.apply(2, 5)).isEqualTo(10);
        assertThat(multiplyOperation.apply(12, 5)).isEqualTo(60);
    }
}