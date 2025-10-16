import java.util.*;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            char current = s.charAt(r);

            while (set.contains(current)) {
                set.remove(s.charAt(l));
                l++;
            }

            set.add(current);
            maxLength = Math.max(maxLength, r - l + 1);
        }

        return maxLength;
    }
}
