import java.util.*;

public class House_Robber_II {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob houses [0 ... n-2]
        int case1 = helper(Arrays.copyOfRange(nums, 0, n - 1));
        // Case 2: Rob houses [1 ... n-1]
        int case2 = helper(Arrays.copyOfRange(nums, 1, n));

        return Math.max(case1, case2);
    }

    public int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for (int n : nums) {
            int newRob = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }
        return rob2;
    }
}
