import java.util.Arrays;

public class Three_Sum_Closest {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                // Update closest if smaller difference found
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = sum;
                }

                // Move pointers based on comparison
                if (sum == target) {
                    return sum; // best possible case
                } else if (sum < target) {
                    j++; // need a larger sum
                } else {
                    k--; // need a smaller sum
                }
            }
        }

        return closestSum;
    }
}
