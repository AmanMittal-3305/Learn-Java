import java.util.*;
public class TarjanAlgorithm {
    static class Edge{
        int src,dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        // 1st vertex
        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        // 2nd vertex
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,0));

        // 3rd vertex
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,0));
//        graph[3].add(new Edge(3,5));

        // 4th vertex
        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

        // 5th vertex
        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
    }
    public static void dfs(ArrayList<Edge>[] graph, int src, int par, int[] dt, int[] low, int time, boolean[] vis){
        vis[src] = true;
        dt[src] = low[src] = ++time;
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            int neigh = e.dest;
            if(neigh == par) continue;
            else if(!vis[neigh]) {
                dfs(graph, neigh, src, dt, low, time, vis);
                low[src] = Math.min(low[src], low[neigh]);
                if (dt[src] < low[neigh]) {
                    System.out.println("Bridge: " + src + " ----- " + neigh);
                }
            } else {
                low[src] = Math.min(low[src], dt[neigh]);
            }
        }
    }

    public static void tarjanBridge(ArrayList<Edge>[] graph, int V){
        int[] dt = new int[V];
        int[] low = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(graph, i, -1, dt, low, time, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        tarjanBridge(graph, V);
    }
}
