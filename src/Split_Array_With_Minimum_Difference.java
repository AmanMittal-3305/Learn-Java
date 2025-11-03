public class Split_Array_With_Minimum_Difference {
    public long splitArray(int[] nums) {
        int n = nums.length;
        if (n < 2) return -1;

        long[] prefix = new long[n];
        long[] suffix = new long[n];

        // Build prefix sum
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        // Build suffix sum
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + nums[i];
        }

        // Precompute strict increasing / decreasing
        boolean[] inc = new boolean[n];
        boolean[] dec = new boolean[n];

        inc[0] = true;
        for (int i = 1; i < n; i++) {
            inc[i] = inc[i - 1] && (nums[i] > nums[i - 1]);
        }

        dec[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            dec[i] = dec[i + 1] && (nums[i] > nums[i + 1]);
        }

        long minDiff = Long.MAX_VALUE;
        boolean valid = false;

        // Check possible split points
        for (int i = 0; i < n - 1; i++) {
            if (inc[i] && dec[i + 1]) {
                long diff = Math.abs(prefix[i] - suffix[i + 1]);
                minDiff = Math.min(minDiff, diff);
                valid = true;
            }
        }

        return valid ? minDiff : -1;
    }
}
