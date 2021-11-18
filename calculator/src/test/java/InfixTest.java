import beans.Notation;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class InfixTest {
    @Autowired
    Notation infixBean;

    @Test
    void testAddCalc() {
        assertEquals(15.0, infixBean.calc("( 10 + 5 )"));
    }

    @Test
    void testMinusCalc() {
        assertEquals(5.0, infixBean.calc("( 10 - 5 )"));
    }

    @Test
    void testMultiplyCalc() {
        assertEquals(50.0, infixBean.calc("( 10 * 5 )"));
    }

    @Test
    void testDivideCalc() {
        assertEquals(2.0, infixBean.calc("( 10 / 5 )"));
    }

    @Test
    void testComplexCalc() {
        assertEquals(45.0, infixBean.calc("( ( 10 + 5 ) * 3 )"));
    }
}
