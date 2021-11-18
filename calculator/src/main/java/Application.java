import beans.InputReader;
import beans.Notation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        InputReader inputReaderBean = ctx.getBean(InputReader.class);
        Notation notationBean = ctx.getBean(Notation.class);

        String input = inputReaderBean.read();
        System.out.println(notationBean.calc(input));
    }
}
