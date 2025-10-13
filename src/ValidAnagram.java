import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] c_s = s.toCharArray();
        char[] c_t = t.toCharArray();
        Arrays.sort(c_s);
        Arrays.sort(c_t);
        return Arrays.equals(c_s, c_t);
    }
}
