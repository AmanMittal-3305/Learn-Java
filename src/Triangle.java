import java.util.*;

public class Triangle {
    public int dfs(List<List<Integer>> triangle, int i, int idx, Integer[][] dp) {
        // Base case: reached past last row
        if (idx == triangle.size())
            return 0;

        // memoized
        if (dp[idx][i] != null)
            return dp[idx][i];

        int curr = triangle.get(idx).get(i);

        // Recur for both downward moves
        int down = dfs(triangle, i, idx + 1, dp);
        int downRight = dfs(triangle, i + 1, idx + 1, dp);

        return dp[idx][i] = curr + Math.min(down, downRight);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return dfs(triangle, 0, 0, dp);
    }
}
