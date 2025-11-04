import java.util.*;

public class Reorganize_String {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );
        pq.addAll(freq.entrySet());

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;

        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> curr = pq.poll();
            result.append(curr.getKey());
            curr.setValue(curr.getValue() - 1);

            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }
            prev = curr;
        }

        if (result.length() != n) return "";
        return result.toString();
    }
}
