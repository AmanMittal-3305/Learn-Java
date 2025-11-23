public class Concatenate_Non_Zero_Digits_and_Multiply_by_Sum_II {
    private final int MOD = 1000000007;
    public int[] sumAndMultiply(String str, int[][] queries) {
        int n = str.length();
        int quer = queries.length;
        int[] res = new int[quer];
        char[] ch = str.toCharArray();
        long[] val = new long[n+1];
        long[] digitSum = new long[n+1];
        long[] arr = new long[n+1];
        int[] count = new int[n+1];

        arr[0] = 1;
        for(int i = 1; i <= n; i++){
            arr[i] = (arr[i-1] * 10) % MOD;
            char c = ch[i-1];
            val[i] = val[i-1];
            digitSum[i] = digitSum[i-1];
            count[i] = count[i-1];
            if(c != '0'){
                int num = c - '0';
                val[i] = (val[i] * 10 + num) % MOD;
                digitSum[i] += num;
                count[i]++;
            }
        }

        for(int i = 0; i < quer; i++){
            int s = queries[i][0] + 1;
            int e = queries[i][1] + 1;

            int c = count[e] - count[s-1];
            long sumDigits = digitSum[e] - digitSum[s-1];

            if(c == 0){
                res[i] = 0;
                continue;
            }

            long valE = val[e];
            long valS = val[s-1];

            long temp = (valE - (valS * arr[c]) % MOD + MOD) % MOD;

            long ans = (temp * (sumDigits % MOD)) % MOD;
            res[i] = (int) ans;
        }

        // long valR = val[]

        return res;

    }
}
