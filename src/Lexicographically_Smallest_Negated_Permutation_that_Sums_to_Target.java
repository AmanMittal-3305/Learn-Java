import java.util.Arrays;
public class Lexicographically_Smallest_Negated_Permutation_that_Sums_to_Target {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long sumTot = (long) n * (n+1) / 2;
        long diff = sumTot - target;

        if(diff < 0 || (diff & 1L) == 1L){
            return new int[0];
        }

        long halfDiff = diff / 2;
        // if(halfDiff)

        boolean[] arr = new boolean[n+1];

        for(int i = n; i > 0 && halfDiff > 0; --i){
            if(i <= halfDiff){
                arr[i] = true;
                halfDiff -= i;
            }
        }

        if(halfDiff != 0){
            return new int[0];
        }

        int[] res = new int[n];
        for(int i = 1; i <= n; ++i){
            res[i-1] = arr[i] ? -i : i;
        }

        Arrays.sort(res);
        return res;
    }
}
