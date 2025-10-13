public class Product_of_Array_Except_Self {

    //1st approach

     public int[] productExceptSelf(int[] nums) {

         int n = nums.length;

         int[] prefix = new int[n+1];
         prefix[0] = 1;

         for(int i = 1; i <= n; i++){
             prefix[i] = prefix[i-1] * nums[i-1];
         }

         int[] suffix = new int[n+1];
         suffix[n] = 1;

         for(int i = n-1; i >= 0; i--){
             suffix[i] = suffix[i+1] * nums[i];
         }

         int[] res = new int[n];
         for(int i = 1; i <= n; i++){
             res[i-1] = prefix[i-1] * suffix[i];
         }

         return res;
     }


    //2nd approach bu ai

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: fill prefix products in res
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: multiply with suffix products on the fly
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= suffix;
            suffix *= nums[i];
        }

        return res;
    }
}
