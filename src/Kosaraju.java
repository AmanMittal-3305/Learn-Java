import java.util.*;

public class Kosaraju {
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
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        // 1st vertex
        graph[1].add(new Edge(1,0));

        // 2nd vertex
        graph[2].add(new Edge(2,1));

        // 3rd vertex
        graph[3].add(new Edge(3,4));
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){
        vis[curr] = true;
        System.out.print(curr + " ");
        for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void topSort(ArrayList<Edge>[] graph, int curr, boolean[] vis, Stack<Integer> s){
        vis[curr] = true;
        for(Edge e : graph[curr]){
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(curr);
    }

    public static void kosorajuAlgo(ArrayList<Edge>[] graph, int V){  //O(V+E)
        //Step 1: Perform topological sorting
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                topSort(graph, i, vis, s);
            }
        }

        //Step 2: Transpose the graph
        ArrayList<Edge>[] transpose = new ArrayList[V];
        for(int i = 0; i < V; i++){
            vis[i] = false; //reset the visited array
            transpose[i] = new ArrayList<>();
        }
        for(int i = 0; i < V; i++){
            for(Edge e : graph[i]){
                transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse the edges
            }
        }

        //Step 3: Perform dfs on the transpose graph
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!vis[curr]){
                System.out.print("SCC: ");
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        kosorajuAlgo(graph, V);
    }
}
