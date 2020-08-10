package eva.recipes.chapter2calculator.calculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTests {

    @Rule
    public OutputCaptureRule capture = new OutputCaptureRule();

    @MockBean(name = "divisionOperator")
    private Operation mockOperation;

    @Autowired
    private Calculator calculator;



    @Test
    public void calculatorShouldHave3Operations(){
        Object operations = ReflectionTestUtils.getField(calculator, "operations");
        assertThat((Collection)operations).hasSize(3);
    }

    @Test
    public void mockDivision(){
        when(mockOperation.handles('/')).thenReturn(true);
        when(mockOperation.apply(14, 7)).thenReturn(2);

        calculator.calculate(14, 7, '/');
        capture.expect(Matchers.containsString("14 / 7 = 2"));
    }

    @Test
    public void doingMultiplicationsShouldSucceed(){
        calculator.calculate(12,13, '*');
        capture.expect(Matchers.containsString("12 * 13 = 156"));
    }

    @Test
    public void doingAdditionShouldSucceed(){
        calculator.calculate(12, 13, '+');
        capture.expect(Matchers.containsString("12 + 13 = 25"));
    }

    @Test
    public void doingDivisionShouldFail(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate(12, 13, '/');
        });
    }

}