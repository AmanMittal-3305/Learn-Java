import java.util.*;

public class Find_Minimum_Time_to_Reach_Last_Room_I {
    static class Cell{
        int row,col,time;
        public Cell(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public static void createGraph(ArrayList<Cell>[] graph){
        for(int i = 0;i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 3;
        int time = 0;
    }
}
