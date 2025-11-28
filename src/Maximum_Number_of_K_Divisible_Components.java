import java.util.*;

public class Maximum_Number_of_K_Divisible_Components {
    private List<Integer>[] graph;
    private int[] values;
    private int k;
    private int count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.values = values;
        this.k = k;
        this.count = 0;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(0, -1);

        return count;
    }

    public long dfs(int node, int parent) {
        long total = values[node];

        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                total += dfs(neighbor, node);
            }
        }

        if (total % k == 0) {
            count += 1;
            return 0;
        }

        return total;
    }
}
