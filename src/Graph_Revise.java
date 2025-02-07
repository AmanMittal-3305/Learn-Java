import java.util.*;

public class Graph_Revise {
    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        // 0th vertex
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        // 1st vertex
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        // 2nd vertex
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        // 3rd vertex
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        // 4th vertex
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        // 5th vertex
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

        // 6th vertex
        graph[6].add(new Edge(6,5,1));
    }

    public static void bfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                bfsUtil(graph, vis);
            }
        }
    }

    public static void bfsUtil( ArrayList<Edge>[] graph, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int curr = q.remove();
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;
                for(int i = 0; i < graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    if(!vis[e.dest]){
                        q.add(e.dest);
                    }
                }
            }
        }
    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
              dfsUtil(graph, vis, i);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr){
        System.out.print(curr + " ");
        vis[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph, vis, e.dest);
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest){
        boolean[] vis = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(hasPathUtil(graph, vis, src, dest)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasPathUtil(ArrayList<Edge>[] graph, boolean[] vis, int src, int dest){
        vis[src] = true;
        if(src == dest){
            return true;
        }
        for (int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!vis[e.dest]){
                if(hasPathUtil(graph, vis, e.dest, dest)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!vis[i]){
                if(isCycleUtil(graph, vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycleUtil(ArrayList<Edge>[] graph, boolean[] vis, int src, int par){
        vis[src] = true;
        for(int i = 0; i < graph[src].size(); i++){
            Edge e = graph[src].get(i);
            //case 1
            if(vis[e.dest] && e.dest != par){
                return true;
            }
            //case 2
            else if(!vis[e.dest]) {
                if (isCycleUtil(graph, vis, e.dest, src)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isBiPartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        Arrays.fill(col, -1);
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) {
                q.add(i);
                col[i] = 0;

                while (!q.isEmpty()) {
                    int curr = q.remove();

                    for (Edge e : graph[curr]) {
                        if (col[e.dest] == -1) {
                            col[e.dest] = 1 - col[curr]; // Assign opposite color
                            q.add(e.dest);
                        } else if (col[e.dest] == col[curr]) {
                            return false; // Conflict in coloring
                        }
                    }
                }
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
//        bfs(graph);
//        dfs(graph);
//        System.out.println(hasPath(graph, 0,5));
//        System.out.println(isCycle(graph));
        System.out.println(isBiPartite(graph));

    }
}
