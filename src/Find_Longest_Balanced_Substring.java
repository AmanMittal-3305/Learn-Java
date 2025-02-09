public class Find_Longest_Balanced_Substring {
    public static int findTheLongestBalancedSubstring(String s) {
        int maxLength = 0;
        int zeroes = 0;
        int ones = 0;
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == '0') {
                zeroes++;
                i++;
            }
            while (i < s.length() && s.charAt(i) == '1') {
                ones++;
                i++;
            }
            maxLength = Math.max(maxLength, 2 * Math.min(zeroes, ones));
            zeroes = 0;
            ones = 0;
        }
        return maxLength;
    }
}
