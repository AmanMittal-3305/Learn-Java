import java.util.*;

public class Custom_Sort_String {
    public String customSortString(String order, String s) {
        // store all characters in order
        Set<Character> orderSet = new HashSet<>();
        for (int i = 0; i < order.length(); i++) {
            orderSet.add(order.charAt(i));
        }

        StringBuilder res = new StringBuilder();

        // add characters that are in 'order' in the given order
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ch) {
                    res.append(ch);
                }
            }
        }

        // now add characters from s that are NOT in 'order'
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!orderSet.contains(ch)) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
