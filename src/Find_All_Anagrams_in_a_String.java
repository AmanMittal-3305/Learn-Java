import java.util.*;

public class Find_All_Anagrams_in_a_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n1 = s.length(), n2 = p.length();
        if (n1 < n2) return res;

        int[] freqP = new int[26];
        int[] freqS = new int[26];

        // Count frequency in p
        for (char c : p.toCharArray()) {
            freqP[c - 'a']++;
        }

        // Initialize first window
        for (int i = 0; i < n2; i++) {
            freqS[s.charAt(i) - 'a']++;
        }

        // Compare first window
        if (matches(freqP, freqS)) res.add(0);

        // Slide the window
        for (int i = n2; i < n1; i++) {
            freqS[s.charAt(i) - 'a']++;          // add new char
            freqS[s.charAt(i - n2) - 'a']--;     // remove old char

            if (matches(freqP, freqS)) res.add(i - n2 + 1);
        }

        return res;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
