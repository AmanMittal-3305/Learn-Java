import java.util.*;

public class Longest_Increasing_Subsequence {

    public static int lcs(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(arr1[i-1] == arr2[j-1]){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static int lis(int[] arr1){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        int[] arr2 = new int[set.size()];
        int i = 0;
        for(int num : set){
            arr2[i] = num;
            i++;
        }
        Arrays.sort(arr2);
        int ans = lcs(arr1,arr2);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {50,3,10,7,40,80};
        System.out.println("Answer is : " + lis(arr));
    }
}
