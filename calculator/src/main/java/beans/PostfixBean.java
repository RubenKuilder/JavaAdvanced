package beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
@Profile("postfix")
public class PostfixBean implements Notation {
    @Override
    public Double calc(String sum) {
        String[] strArr = sum.split(" ");
        Stack<Double> operands = new Stack<Double>();

        for (String str : strArr)
        {
            if(str.trim().equals("")) {
                continue;
            }

            switch(str) {
                case "+":
                case "-":
                case "*":
                case "/":
                    double right = operands.pop();
                    double left = operands.pop();

                    switch (str) {
                        case "+":
                            operands.push(left + right);
                            break;
                        case "-":
                            operands.push(left - right);
                            break;
                        case "*":
                            operands.push(left * right);
                            break;
                        case "/":
                            operands.push(left / right);
                            break;
                    }
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;
            }
        }

        return operands.pop();
    }
}
