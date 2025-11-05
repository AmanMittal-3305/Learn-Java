import java.util.*;

public class Score_of_Parentheses {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Base score

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int factor = stack.pop();
                int maxVal = Math.max(2 * factor, 1);
                int top = stack.pop();
                stack.push(top + maxVal);
            }
        }

        return stack.pop();
    }
}
