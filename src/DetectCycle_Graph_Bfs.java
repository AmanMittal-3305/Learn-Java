import java.util.*;

public class DetectCycle_Graph_Bfs {
    static class Edge {
        int src, dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed graph edges
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 1)); // Back edge creating a cycle
    }

    public static boolean isCycle(ArrayList<Edge>[] graph) {
        int V = graph.length;
        int[] inDegree = new int[V];

        // Calculate in-degree of each node
        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                inDegree[e.dest]++;
            }
        }

        // Enqueue nodes with zero in-degree
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Process the nodes
        int count = 0; // To count processed nodes
        while (!q.isEmpty()) {
            int curr = q.remove();
            count++;

            // Decrease the in-degree of neighbors
            for (Edge e : graph[curr]) {
                inDegree[e.dest]--;
                if (inDegree[e.dest] == 0) {
                    q.add(e.dest);
                }
            }
        }

        // If count of processed nodes is less than total nodes, there's a cycle
        return count != V;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        if (isCycle(graph)) {
            System.out.println("Cycle detected!");
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
