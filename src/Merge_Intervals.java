import java.util.*;

public class Merge_Intervals {
    class Pair {
        int l, r;
        Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        //Sort accordding to start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<Pair> list = new ArrayList<>();
        list.add(new Pair(intervals[0][0], intervals[0][1]));

        for (int i = 1; i < intervals.length; i++) {
            int[] t = intervals[i];
            Pair last = list.get(list.size() - 1);

            if (last.r >= t[0]) { // overlap
                last.r = Math.max(last.r, t[1]);
            } else { // no overlap
                list.add(new Pair(t[0], t[1]));
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i][0] = list.get(i).l;
            res[i][1] = list.get(i).r;
        }

        return res;
    }
}
