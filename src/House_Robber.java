import java.util.*;

public class House_Robber {
    public int robDP(int n, int[] dp, int[] nums) {
        // base case
        if (n < 0) return 0;
        if (n == 0) return nums[0];

        // already computed
        if (dp[n] != -1) return dp[n];

        // choose to rob or skip
        int pick = nums[n] + robDP(n - 2, dp, nums);
        int skip = robDP(n - 1, dp, nums);

        dp[n] = Math.max(pick, skip);
        return dp[n];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return robDP(n - 1, dp, nums);
    }
}
