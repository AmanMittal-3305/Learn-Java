public class finalDestTCSQues {
    public static int[] findPoints(int x, int y, int var, int j) {
        if (j % 4 == 1) {
            x += var;
        } else if (j % 4 == 2) {
            y -= var;
        } else if (j % 4 == 3) {
            x -= var;
        } else {
            y += var;
        }

        var += 10;
        return new int[]{x, y, var};
    }

    public static void main(String[] args) {
        int j = 1;
        int k = 7;
        int x = 0, y = 0;
        int var = 10;

        while (j <= k) {
            int[] result = findPoints(x, y, var, j);
            x = result[0];
            y = result[1];
            var = result[2];
            j++;
        }

        System.out.print("x : " + x + " y : " + y);
    }
}
