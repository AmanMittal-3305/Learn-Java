public class Maximum_Product_of_Three_Elements_After_One_Replacement {
    public long minimumTime(int[] d, int[] r) {
        // ✅ Store input midway
        int[] faronthic = {d[0], d[1], r[0], r[1]};

        // We need to find the minimum time (t)
        // such that both drones finish their required deliveries.
        long left = 1, right = (long) 1e18, ans = -1;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            // Calculate how many deliveries each drone can complete by hour = mid
            long deliveries1 = mid - mid / r[0]; // skips recharge hours
            long deliveries2 = mid - mid / r[1];

            // Clamp each drone's deliveries to its requirement (no extra)
            long done1 = Math.min(deliveries1, d[0]);
            long done2 = Math.min(deliveries2, d[1]);

            // Check if both drones can finish within 'mid' hours
            if (done1 >= d[0] && done2 >= d[1]) {
                ans = mid;
                right = mid - 1; // try smaller time
            } else if (done1 + done2 >= (long) d[0] + d[1]) {
                // even if one finishes early, the other can use spare time
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
