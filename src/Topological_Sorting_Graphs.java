import java.util.*;
public class Topological_Sorting_Graphs {
    static class Edge{
        int src, dest;
        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }
//    https://hianime.to/watch/infinite-stratos-4398?ep=37826
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[1].add(new Edge(1,2));
    }

    public static void topologicalSort(ArrayList<Edge>[] graph, int src){
        boolean[] vis = new boolean[graph.length];
        System.out.print(src+ " ");
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                Edge e = graph[src].get(i);
                topologicalSort(graph,e.dest );
            }
        }
    }

    public static void main(String[] args) {
        int V = 3;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        topologicalSort(graph, 0);
    }
}
