import java.util.*;

public class ConnectNRopes {
    public static void main(String[] args) {
        int[] ropes = {4,3,2,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int rope : ropes) {
            pq.add(rope);
        }
        int cost = 0;
        while(pq.size() > 1){
            int firstMin = pq.remove();
            int secMin = pq.remove();
            cost += firstMin + secMin;
            pq.add(firstMin + secMin);
        }
        System.out.println(cost);
    }
}
