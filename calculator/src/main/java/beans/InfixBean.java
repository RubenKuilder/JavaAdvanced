package beans;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Stack;

@Component
@Profile("infix")
public class InfixBean implements Notation {
    @Override
    public Double calc(String sum) {
        String[] strArr = sum.split(" ");
        Stack<String> operators = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();

        for(String str : strArr) {
            if(str.trim().equals("")) {
                continue;
            }

            switch(str) {
                case "(":
                    break;
                case ")":
                    double right = operands.pop();
                    double left = operands.pop();
                    String operator = operators.pop();
                    double value = 0;

                    switch(operator) {
                        case "+":
                            value = left + right;
                            break;
                        case "-":
                            value = left - right;
                            break;
                        case "*":
                            value = left * right;
                            break;
                        case "/":
                            value = left / right;
                            break;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                case "+":
                case "-":
                case "*":
                case "/":
                    operators.push(str);
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;
            }
        }
        return operands.pop();
    }
}