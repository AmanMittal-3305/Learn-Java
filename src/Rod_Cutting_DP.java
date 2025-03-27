import java.util.*;

public class Rod_Cutting_DP {

    public static void print(int[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int maxProfit(int[] length, int[] price, int totalLength){
        int n = length.length;
        int[][] dp = new int[n+1][totalLength+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < totalLength +1; j++){
                if(length[i-1] <= j){ // valid
                    int incProfit = price[i-1] + dp[i][j-length[i-1]];
                    int excProfit = dp[i-1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                }else{ // invalid
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][totalLength];
    }
    public static void main(String[] args) {
        int[] length = {1,2,3,4,5,6,7,8};
        int[] price = {1,5,8,9,10,17,17,20};
        int totalLength = 8;
        System.out.println("Answer is : " + maxProfit(length, price, totalLength));
    }
}
