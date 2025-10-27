import java.util.*;

public class Coin_Change { // O(n * sum)
    public static void print(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int totalWays(int[] coins, int sum){
        int n = coins.length;
        int[][] dp = new int[coins.length+1][sum+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < sum + 1; j++){
                int v = coins[i-1];
                //include
                if(v <= j){
                    dp[i][j] = dp[i][j-v] + dp[i-1][j];
                }
                //exclude
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];
    }

    public int dpHelper(int[] coins, int amt, int[] dp) {
        if (amt == 0) return 0; // no coins needed
        if (amt < 0) return Integer.MAX_VALUE; // impossible
        if (dp[amt] != -1) return dp[amt];

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dpHelper(coins, amt - coin, dp);
            if (res != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + res);
            }
        }

        dp[amt] = minCoins;
        return dp[amt];
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int ans = dpHelper(coins, amount, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int sum = 11;
        System.out.println("Answer is : " + totalWays(coins,sum));
    }
}
