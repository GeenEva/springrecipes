package eva.recipes.chapter2calculator.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.Mockito.when;

class CalculatorTest {

    private Calculator calculator;
    private Operation mockOperation;

    @BeforeEach
    void setUp() {
        mockOperation = Mockito.mock(Operation.class);
        calculator = new Calculator(Collections.singletonList(mockOperation));
    }

    @Test
    public void throwExceptionWhenNoSuitableOperationFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            when(mockOperation.handles(anyChar())).thenReturn(false);
            calculator.calculate(2, 9, '*');
                });
    }

    @Test
    public void shouldCallApplyMethodWhenSuitableOperationFound(){
        /*
        The mock is instructed to return true for the handles method
        and a return value for the apply method.
         */
        when(mockOperation.handles(anyChar())).thenReturn(true);
        when(mockOperation.apply(2, 5)).thenReturn(6);
    }
}