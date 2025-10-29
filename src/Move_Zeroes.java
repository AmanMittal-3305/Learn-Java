public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        int k = 0;
        if(nums.length == 1){
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[k] = nums[i];
                k++;
            }
        }
        for(int idx  = k; idx < nums.length; idx++){
            nums[idx] = 0;
        }
    }
}
