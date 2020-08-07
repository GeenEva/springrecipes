package eva.recipes.chapter2calculator.calculator;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureRule;


@SpringBootTest(classes = CalculatorApplication.class)
public class CalculatorApplicationTests {

    @Rule
    public OutputCaptureRule capture = new OutputCaptureRule();

    @Autowired
    private Calculator calculator;

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