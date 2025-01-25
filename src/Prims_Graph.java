import java.util.*;

public class Prims_Graph {
    static class Edge{
        int src, dest, wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
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

    static class Pair implements Comparable<Pair>{
        int v, cost;
        public Pair(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost; //ascending
        }
    }

    public static void prims(ArrayList<Edge>[] graph){
        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0,0));
        int mstWt = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!vis[curr.v]){
                vis[curr.v] = true;
                mstWt += curr.cost;

                for(int i = 0; i < graph[curr.v].size(); i++){
                    Edge e = graph[curr.v].get(i);
                    pq.add(new Pair(e.dest, e.wt));
                }
            }
        }
        System.out.print("Final cost of MST Tree : " + mstWt);
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);
        prims(graph);
    }
}
