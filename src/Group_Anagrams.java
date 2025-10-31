import java.util.*;

public class Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Check if key exists
            if (map.containsKey(key)) {
                // If it exists, add the current string to the existing list
                map.get(key).add(s);
            } else {
                // If it doesn't exist, create a new list, add the string, and put it in the map
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }


        return new ArrayList<>(map.values());
    }
}
