public class Total_Waviness_of_Numbers_in_Range_I {
    public boolean isPeak(int n){
        String s = Integer.toString(n);
        char[] ch = s.toCharArray();
        for(int i = 1; i < ch.length - 1; i++){
            if((ch[i] - '0') > (ch[i-1] - '0') && (ch[i] - '0') > (ch[i+1] - '0')){
                return true;
            }
        }
        return false;
    }
    public boolean isValley(int n){
        String s = Integer.toString(n);
        char[] ch = s.toCharArray();
        for(int i = 1; i < ch.length - 1; i++){
            if((ch[i] - '0') < (ch[i-1] - '0') && (ch[i] - '0') < (ch[i+1] - '0')){
                return true;
            }
        }
        return false;
    }
    public int res(int n){
        String s = Integer.toString(n);
        char[] ch = s.toCharArray();
        int count = 0;
        for(int i = 1; i < ch.length - 1; i++){
            int prev = ch[i-1] - '0';
            int curr = ch[i] - '0';
            int next = ch[i + 1] - '0';
            if(curr > prev && curr > next){
                count++;
            }
            if(curr < prev && curr < next){
                count++;
            }
        }
        return count;
    }
    public int totalWaviness(int num1, int num2) {
        // if(num1 < 100 || num2 < 100 || num1 > num2){
        //     return 0;
        // }

        int count = 0;

        for(int i = num1; i <= num2; i++){
            if(i < 100){
                continue;
            }
            count += res(i);
        }
        return count;
    }
}
