import java.util.*;

public class Compute_Decimal_Representation {
    public int[] decimalRepresentation(int n) {
        List<Integer> list = new ArrayList<>();
        int k = 0;

        while (n > 0) {
            int rem = n % 10;
            if (rem > 0) {
                list.add(rem * (int) Math.pow(10, k));
            }
            n /= 10;
            k++;
        }

        // Reverse to get the natural order (from most to least significant)
        Collections.reverse(list);

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
