public class Count_and_Say {
    public String helper(StringBuilder sb, int i, int n) {
        if (i > n) {
            return sb.toString();
        }

        StringBuilder newStr = new StringBuilder();
        String curr = sb.toString();
        int idx = 0;

        while (idx < curr.length()) {
            int count = 0;
            char c = curr.charAt(idx);
            while (idx < curr.length() && curr.charAt(idx) == c) {
                count++;
                idx++;
            }
            newStr.append(count).append(c);
        }

        return helper(new StringBuilder(newStr.toString()), i + 1, n);
    }

    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        return helper(sb, 2, n); // start from term 2
    }
}
