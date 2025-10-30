import java.util.*;

public class Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store (prefix sum, frequency)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum = 0;

        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k); // add the frequency found
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1); // update frequency
        }
        return count;
    }
}
