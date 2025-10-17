import java.util.*;

public class MinStack {
    Stack<Integer> s;

    public MinStack() {
        s = new Stack<>();
    }

    public void push(int val) {
        s.push(val);
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        int[] arr = new int[s.size()];
        Stack<Integer> copy = (Stack<Integer>) s.clone();
        int i = 0;
        while(!copy.isEmpty()){
            arr[i++] = copy.pop();
        }
        Arrays.sort(arr);
        return arr[0];
    }
}
