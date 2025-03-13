import java.util.*;

public class Find_the_City_With_Smallest_Number_of_Neighbors_at_a_Threshold_Distance {
    static class Edge {
        int src, dest, wt;
        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n, path;
        public Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] edges) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph[from].add(new Edge(from, to, weight));
            graph[to].add(new Edge(to, from, weight));
        }
    }

    public int dijkstra(ArrayList<Edge>[] graph, int src, int distanceThreshold) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0; // Distance from source to itself is 0

        boolean[] vis = new boolean[graph.length];

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (vis[curr.n]) continue;

            vis[curr.n] = true;

            // Check neighbors
            for (Edge e : graph[curr.n]) {
                int v = e.dest;
                int wt = e.wt;

                if (!vis[v] && dist[curr.n] + wt < dist[v]) {
                    dist[v] = dist[curr.n] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        int count = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i != src && dist[i] <= distanceThreshold) { // Include <= to match threshold
                count++;
            }
        }
        return count;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph, edges);
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = dijkstra(graph, i, distanceThreshold);
        }

        // Find the city with the minimum reachable cities and the highest index
        int minCount = Integer.MAX_VALUE;
        int city = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < minCount || (arr[i] == minCount && i > city)) {
                minCount = arr[i];
                city = i;
            }
        }

        return city;
    }
}
