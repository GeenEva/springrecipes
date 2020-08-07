package eva.recipes.chapter2calculator.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class)
class CalculatorApplicationTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void doingDivisionShouldFail(){
        Assertions.assertThrows(Exception.class, () -> {
            calculator.calculate(12, 13, '/');
        });

    }

}