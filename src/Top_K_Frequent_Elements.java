import java.util.*;

public class Top_K_Frequent_Elements {

    class Pair implements Comparable<Pair>{
        int num, freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
        @Override
        public int compareTo(Pair p2){
            return p2.freq - this.freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }

        int[] res = new int[k];

        for(int i = 0; i < k; i++){
            Pair p = pq.poll();
            res[i] = p.num;
        }

        return res;
    }
}
