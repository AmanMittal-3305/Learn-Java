import java.util.*;

public class Topological_Sorting_Graphs {
    static class Edge {
        int src, dest;
        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
//        graph[0].add(new Edge(0, -1));
//        graph[1].add(new Edge(1, -1));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> stack) {
        vis[curr] = true;
        for (Edge edge : graph[curr]) {
            if (!vis[edge.dest]) {
                topologicalSort(graph, edge.dest, vis, stack);
            }
        }
        stack.push(curr);
    }

    public static void main(String[] args) {
        int V = 6; // Updated to 6 since there are vertices 0 through 5
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                topologicalSort(graph, i, vis, stack);
            }
        }

        // Print topological order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
