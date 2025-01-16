import java.util.*;

public class Dijkstra_Graph {
    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable<Pair>{
        int n,dist;
        public Pair(int n, int dist){
            this.n = n;
            this.dist = dist;
        }
        @Override
        public int compareTo(Pair p){
            return this.dist - p.dist;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        //0th node
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        //1st node
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        //2nd node
        graph[2].add(new Edge(2,4,3));

        //3rd node
        graph[3].add(new Edge(3,5,1));

        //4th node
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    public static void dijkstra(ArrayList<Edge>[] graph, int src){

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
    }
}
