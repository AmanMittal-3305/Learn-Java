import java.util.*;

public class Valid_Parentheses {
    // public boolean isValid(String s) {
    //     Stack<Character> st = new Stack<>();
    //     Map<Character, Character> map = Map.of(
    //         ')', '(',
    //         ']', '[',
    //         '}', '{'
    //     );

    //     for (char c : s.toCharArray()) {
    //         if (map.containsValue(c)) {
    //             st.push(c);
    //         } else if (map.containsKey(c)) {
    //             if (st.isEmpty() || st.pop() != map.get(c)) {
    //                 return false;
    //             }
    //         }
    //     }
    //     return st.isEmpty();
    // }

    public boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                if(s.size() < 1){
                    return false;
                }
                char curr = s.pop();
                if(curr == '('){
                    if(ch != ')'){
                        return false;
                    }
                }
                if(curr == '{'){
                    if(ch != '}'){
                        return false;
                    }
                }
                if(curr == '['){
                    if(ch != ']'){
                        return false;
                    }
                }
            }
        }
        return s.size() == 0;
    }
}
