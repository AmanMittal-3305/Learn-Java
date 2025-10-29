public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, k = 0;
        int n = nums.length;
        while(i < n){
            int temp = nums[i];
            while(j < n && nums[i] == nums[j] ){
                j++;
            }
            i=j;
            nums[k] = temp;
            k++;
        }

        return k;
    }
}
