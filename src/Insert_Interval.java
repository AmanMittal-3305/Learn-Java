import java.util.*;

public class Insert_Interval {
    class Pair {
        int l, r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Pair> list = new ArrayList<>();

        int i = 0, n = intervals.length;
        int newL = newInterval[0], newR = newInterval[1];

        // 1️⃣ Add all intervals that end *before* newInterval starts
        while (i < n && intervals[i][1] < newL) {
            list.add(new Pair(intervals[i][0], intervals[i][1]));
            i++;
        }

        // 2️⃣ Merge all overlapping intervals
        while (i < n && intervals[i][0] <= newR) {
            newL = Math.min(newL, intervals[i][0]);
            newR = Math.max(newR, intervals[i][1]);
            i++;
        }
        list.add(new Pair(newL, newR)); // merged interval

        // 3️⃣ Add all intervals that start *after* newInterval ends
        while (i < n) {
            list.add(new Pair(intervals[i][0], intervals[i][1]));
            i++;
        }

        // 4️⃣ Convert list to 2D array
        int[][] res = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            res[j][0] = list.get(j).l;
            res[j][1] = list.get(j).r;
        }

        return res;
    }
}
