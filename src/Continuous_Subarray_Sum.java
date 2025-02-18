import java.util.*;

public class Continuous_Subarray_Sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Handle case when subarray starts from index 0
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k; // Handle negative remainders
            }

            if (map.containsKey(remainder)) {
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }

        return false;
    }
}
