import beans.Notation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostfixTest {
    @Autowired
    Notation notationBean;

    @BeforeEach
    void setUp() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        notationBean = ctx.getBean(Notation.class);
    }

    @Test
    void testAddCalc() {
        assertEquals(15.0, notationBean.calc("3 2 +"));
    }

    @Test
    void testMinusCalc() {
        assertEquals(5.0, notationBean.calc("3 2 -"));
    }

    @Test
    void testMultiplyCalc() {
        assertEquals(45.0, notationBean.calc("3 2 *"));
    }

    @Test
    void testDivideCalc() {
        assertEquals(2.0, notationBean.calc("3 2 /"));
    }

    @Test
    void testComplexCalc() {
        assertEquals(45.0, notationBean.calc("3 2 + 2 *"));
    }
}
