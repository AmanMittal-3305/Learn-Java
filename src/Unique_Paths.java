import java.util.Arrays;

public class Unique_Paths {
    public int helper(int i, int j, int m, int n, int[][] dp) {
        // Base case: reached destination
        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        // Out of bounds
        if (i >= m || j >= n) {
            return 0;
        }

        // If already computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Move right and down
        int right = helper(i, j + 1, m, n, dp);
        int down = helper(i + 1, j, m, n, dp);

        // Store result in dp table
        dp[i][j] = right + down;
        return dp[i][j];
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return helper(0, 0, m, n, dp);
    }
}
