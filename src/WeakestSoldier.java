import java.util.*;

public class WeakestSoldier {
    static class Soldier implements Comparable<Soldier>{
        int soldiers, index;
        public Soldier(int soldiers,int index){
            this.soldiers = soldiers;
            this.index = index;
        }
        @Override
        public int compareTo(Soldier s2){
            if(this.soldiers == s2.soldiers){
                return this.index - s2.index;
            }else{
                return this.soldiers - s2.soldiers;
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1,0,0,0}, {1,1,1,1}, {1,0,0,0}, {1,0,0,0}};
        int k = 2;
        PriorityQueue<Soldier> pq = new PriorityQueue<>();

        int count = 0;
        for(int i = 0; i < data.length; i++){
            count = 0;
            for(int j = 0; j < data[0].length; j++){
                if(data[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Soldier(count,i));
        }

        for(int i = 0; i < k ; i++){
            System.out.println("R" + pq.remove().index);
        }
    }
}
