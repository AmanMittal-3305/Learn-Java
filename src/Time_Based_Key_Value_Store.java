import java.util.*;

public class Time_Based_Key_Value_Store {
    private Map<String, List<Pair>> map;

    private static class Pair {
        int timestamp;
        String value;
        Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public Time_Based_Key_Value_Store() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";
        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid).timestamp <= timestamp) {
                res = list.get(mid).value;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
