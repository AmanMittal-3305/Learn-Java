public class Find_Minimum_in_Rotated_Sorted_Array {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            // If mid element is greater than the rightmost element,
            // the minimum is in the right half
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            }
            // Otherwise, the minimum is in the left half (including mid)
            else {
                r = mid;
            }
        }

        // l == r is the index of the minimum element
        return nums[l];
    }
}
