import java.util.*;
public class Minimum_time_required_to_rot_all_oranges {
    static class Classes{
        int empty;
        int fresh;
        int rot;
        public Classes(int e, int f, int r){
            this.empty = e;
            this.fresh = f;
            this.rot = r;
        }
    }
    static void createGraph(ArrayList<Classes>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Directed graph Classess
        graph[0].add(new Classes(0, 1,2));
        graph[1].add(new Classes(1, 2));
        graph[2].add(new Classes(2, 3));
        graph[3].add(new Classes(3, 4));
        graph[4].add(new Classes(4, 1));
    }
}
