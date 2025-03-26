import java.util.*;

public class Target_Sum_Tabulation { //O (n * sum)
    public static void print(boolean[][] dp){
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean targetSum(int[] arr, int targetSum){
        int n = arr.length;
        boolean[][] dp = new boolean[arr.length+1][targetSum+1];
        Arrays.fill(dp[0], false);
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = true;
        }
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < targetSum + 1; j++){
                int v = arr[i-1];
                //include
                if(v <= j){
                    dp[i][j] = dp[i-1][j-v] || dp[i-1][j];
                }
                //exclude
                else if(dp[i - 1][j]){
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[arr.length][targetSum];
    }
    public static void main(String[] args) {
        int[] arr = {4,2,7,1,3};
        int sum = 10;
        System.out.println("Answer is : " + targetSum(arr,sum));
    }
}
