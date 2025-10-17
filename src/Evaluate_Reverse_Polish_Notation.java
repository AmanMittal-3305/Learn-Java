import java.util.*;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid expression: not enough operands");
                }

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/":
                        if (b == 0) {
                            throw new ArithmeticException("Division by zero");
                        }
                        stack.push(a / b);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid expression: leftover operands");
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}
