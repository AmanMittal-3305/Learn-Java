import java.util.*;

public class BiPartite_Graph {
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

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, -1); // -1 indicates unvisited

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) { // If the vertex is unvisited
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                color[i] = 0; // Assign the first color

                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (Edge e : graph[curr]) {
                        if (color[e.dest] == -1) { // If the neighbor is unvisited
                            color[e.dest] = 1 - color[curr]; // Alternate color
                            q.add(e.dest);
                        } else if (color[e.dest] == color[curr]) {
                            // If the neighbor has the same color as the current vertex
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        System.out.println(isBiPartite(graph)); // Output: true
    }
}
