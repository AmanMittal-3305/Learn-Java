import java.util.*;

public class bfs {
    static class Edge{
        int src,dest,wt;
        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }
    static void createGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // 0th vertex
        graph[0].add(new Edge(0,1,5));

        // 1st vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        // 2nd vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));

        // 3rd vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        // 4th vertex
        graph[4].add(new Edge(4,2,2));

    }
}
