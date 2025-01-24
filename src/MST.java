import java.util.*;

public class MST {
    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        // Initialize graph with edges
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 7));
        graph[0].add(new Edge(0, 3, 5));

        graph[1].add(new Edge(1, 0, 7));
        graph[1].add(new Edge(1, 2, 8));
        graph[1].add(new Edge(1, 3, 9));
        graph[1].add(new Edge(1, 4, 7));

        graph[2].add(new Edge(2, 1, 8));
        graph[2].add(new Edge(2, 4, 5));

        graph[3].add(new Edge(3, 0, 5));
        graph[3].add(new Edge(3, 1, 9));
        graph[3].add(new Edge(3, 4, 15));
        graph[3].add(new Edge(3, 5, 6));

        graph[4].add(new Edge(4, 1, 7));
        graph[4].add(new Edge(4, 2, 5));
        graph[4].add(new Edge(4, 3, 15));
        graph[4].add(new Edge(4, 5, 8));
        graph[4].add(new Edge(4, 6, 9));

        graph[5].add(new Edge(5, 3, 6));
        graph[5].add(new Edge(5, 4, 8));
        graph[5].add(new Edge(5, 6, 11));

        graph[6].add(new Edge(6, 4, 9));
        graph[6].add(new Edge(6, 5, 11));
    }

    public static int minimumSpanningTree(ArrayList<Edge>[] graph, int start){
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.wt));
        int mstWeight = 0;

        // Start with the given node
        vis[start] = true;
        for (Edge e : graph[start]) {
            pq.add(e);
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            // Skip if the destination node is already visited
            if (vis[edge.dest]) continue;

            // Mark the destination node as visited
            vis[edge.dest] = true;
            mstWeight += edge.wt;

            // Add all edges from the newly visited node to the priority queue
            for (Edge nextEdge : graph[edge.dest]) {
                if (!vis[nextEdge.dest]) {
                    pq.add(nextEdge);
                }
            }
        }
        return mstWeight;
    }

    public static void main(String[] args) {
        int V = 7; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        // Start from node 0
        int result = minimumSpanningTree(graph, 0);
        System.out.println("Weight of the Minimum Spanning Tree: " + result);
    }
}
