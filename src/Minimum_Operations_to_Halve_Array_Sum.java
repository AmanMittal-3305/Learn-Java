import java.util.*;
public class Minimum_Operations_to_Halve_Array_Sum {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> Double.compare(b, a));
        double totalSum = 0;

        for (int num : nums) {
            pq.add((double) num);
            totalSum += num;
        }

        double halfSum = totalSum / 2;
        int count = 0;

        while (totalSum > halfSum) {
            double maxVal = pq.poll();
            double halfVal = maxVal / 2;
            totalSum -= halfVal;
            pq.add(halfVal);
            count++;
        }

        return count;
    }
}
