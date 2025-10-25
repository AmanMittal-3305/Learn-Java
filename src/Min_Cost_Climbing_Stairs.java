public class Min_Cost_Climbing_Stairs {
    public int minCostClimbingStairs(int[] cost){
        int n = cost.length;
        if(n == 2){
            return Math.min(cost[0], cost[1]);
        }
        int[] arr = new int[n+1];
        arr[n] = 0;
        arr[n-1] = cost[n-1];

        for(int i = n-2; i >= 0; i--){
            arr[i] = cost[i] + Math.min(arr[i+1], arr[i+2]);
        }

        return Math.min(arr[0], arr[1]);

    }
}
