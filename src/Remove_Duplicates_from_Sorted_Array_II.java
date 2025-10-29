public class Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, k = 0;
        int n = nums.length;
        while(i < n){
            int temp = nums[i];
            while(j < n && nums[i] == nums[j] ){
                j++;
            }
            if(j - i > 1){
                nums[k] = temp;
                nums[k+1] = temp;
                k += 2;
            }else{
                nums[k] = temp;
                k++;
            }

            i = j;
        }

        return k;
    }
}
