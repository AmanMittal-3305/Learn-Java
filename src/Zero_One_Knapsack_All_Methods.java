import java.util.*;
public class Zero_One_Knapsack_All_Methods {
    public static int knapsack_recursion(int[] val, int[] wt, int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){ //valid
            //include
            int ans1 =  knapsack_recursion(val, wt, W-wt[n-1], n-1) + val[n-1];
            //exclude
            int ans2 = knapsack_recursion(val, wt, W, n-1);
            return Math.max(ans1, ans2);
        }else{ //invalid
            return knapsack_recursion(val, wt, W, n-1);
        }
    }

    public static int knapsack_memoization(int[] val, int[] wt, int W, int n, int[][] dp){
        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] != -1){
            return dp[n][W];
        }
        if(wt[n-1] <= W){ //valid
            //include
            int ans1 =  knapsack_memoization(val, wt, W-wt[n-1], n-1, dp) + val[n-1];
            //exclude
            int ans2 = knapsack_memoization(val, wt, W, n-1, dp);
            dp[n][W] = Math.max(ans1, ans2);
        }else{ //invalid
            dp[n][W] = knapsack_memoization(val, wt, W, n-1, dp);
        }
        return dp[n][W];
    }

    public static void print(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int knapsack_tabulation(int[] val, int[] wt, int W){
        int n = val.length;
        int[][] dp = new int[val.length+1][W+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < dp[0].length; j++){
            dp[0][j] = 0;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int v = val[i-1]; //ith item value
                int w = wt[i-1]; //ith item weight
                if(w <= j){ //valid
                    int incProfit = v + dp[i-1][j-w];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{ //invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] val = {15,14,10,45,30};
        int[] wt = {2,5,1,3,4};
        int W = 7;
        int[][] dp = new int[val.length+1][W+1];
        //initialization with -1
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(knapsack_tabulation(val, wt, W));
//        System.out.println(knapsack_memoization(val, wt, W, val.length, dp));
//        System.out.println(knapsack_recursion(val, wt, W, val.length));
    }
}
