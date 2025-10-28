public class Missing_Number {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int maxSum = n * (n+1) / 2;
        for(int num: nums){
            maxSum -= num;
        }
        return maxSum;
    }
}
