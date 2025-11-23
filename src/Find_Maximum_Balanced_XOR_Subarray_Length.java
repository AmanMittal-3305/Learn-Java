import java.util.*;

public class Find_Maximum_Balanced_XOR_Subarray_Length {
    public boolean checkCountOddEven(int i, int j, int[] nums){
        int even = 0;
        int odd = 0;
        for(int idx = i; idx <= j; idx++){
            if(nums[idx] % 2 == 0){
                even++;
            }else {
                odd++;
            }
        }

        return odd == even;
    }
    public int maxBalancedSubarray(int[] nums) {
        // int n = nums.length;
        // int maxVal = 0;



        // int[] evenPref = new int[n+1];
        // int[] oddPref = new int[n+1];
        // int[] xorPref = new int[n+1];

        // for(int i = 0; i < n; i++){
        //     evenPref[i+1] = evenPref[i] + (nums[i] % 2 == 0 ? 1 : 0);
        //     oddPref[i+1] = oddPref[i] + (nums[i] % 2 != 0 ? 1 : 0);
        //     xorPref[i+1] = xorPref[i] ^ nums[i];
        // }

        // for(int i = 0; i < n; i++){
        //     for(int j = i+1; j <= n; j++){
        //         int even = evenPref[j] - evenPref[i];
        //         int odd = oddPref[j] - oddPref[i];
        //         int xor = xorPref[j] ^ xorPref[i];

        //         if(even == odd && xor == 0){
        //             maxVal = Math.max(maxVal, j-i);
        //         }
        //     }
        // }
        // return maxVal;



        Map<String, Integer> map = new HashMap<>();
        int xor = 0;
        int diffCount = 0;
        int max = 0;

        map.put("0#0", 0);

        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
            if(nums[i] % 2 == 0){
                diffCount++;
            }else{
                diffCount--;
            }

            String curr = xor + "#" + diffCount;
            if(map.containsKey(curr)){
                int idx = map.get(curr);
                max = Math.max(max, (i+1) - idx);
            }else{
                map.put(curr, i+1);
            }
        }

        return max;
    }
}
