public class Merge_Sorted_Array {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of nums1 and nums2
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;  // Index for the merged array

        // Merge elements from nums1 and nums2
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }

        while(i >= 0){
            nums1[k] = nums1[i];
            i--;
            k--;
        }
    }

}
