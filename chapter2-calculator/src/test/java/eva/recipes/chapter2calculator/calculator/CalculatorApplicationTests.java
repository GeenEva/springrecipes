package eva.recipes.chapter2calculator.calculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTests {

    @Rule
    public OutputCaptureRule capture = new OutputCaptureRule();

    @MockBean
    private Calculator calculator;

    @MockBean(name = "multiplyOperation")
    private Operation mockOperation;

    @Test
    public void calculatorShouldHave3Operations(){
        Object operations = ReflectionTestUtils.getField(calculator, "operations");
        assertThat((Collection)operations).hasSize(2);
    }

    @Test
    public void doingMultiplicationsShouldSucceed(){
        calculator.calculate(12,13, '*');
        capture.expect(Matchers.containsString("12 * 13 = 156"));
    }

    @Test
    public void doingDivisionShouldFail(){
        Assertions.assertThrows(Exception.class, () -> {
            calculator.calculate(12, 13, '/');
        });

    }

}