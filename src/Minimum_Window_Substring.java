import java.util.*;

public class Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> windowCounts = new HashMap<>();
        int required = mapT.size();
        int formed = 0;
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);
            windowCounts.put(ch, windowCounts.getOrDefault(ch, 0) + 1);

            if (mapT.containsKey(ch) && windowCounts.get(ch).intValue() == mapT.get(ch).intValue()) {
                formed++;
            }

            // Try and contract the window till it ceases to be 'desirable'
            while (left <= right && formed == required) {
                ch = s.charAt(left);

                // Save the smallest window until now
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                windowCounts.put(ch, windowCounts.get(ch) - 1);
                if (mapT.containsKey(ch) && windowCounts.get(ch).intValue() < mapT.get(ch).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
