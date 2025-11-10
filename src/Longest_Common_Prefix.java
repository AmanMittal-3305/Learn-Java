public class Longest_Common_Prefix {
    public String findCommon(String curr, String given) {
        StringBuilder res = new StringBuilder();

        int len = Math.min(curr.length(), given.length());
        for (int i = 0; i < len; i++) {
            if (curr.charAt(i) == given.charAt(i)) {
                res.append(curr.charAt(i));
            } else {
                break;
            }
        }

        return res.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        if (n == 1) return strs[0];

        String curr = strs[0];

        for (int i = 1; i < n; i++) {
            curr = findCommon(curr, strs[i]);
            if (curr.equals("")) return "";
        }

        return curr;
    }
}
