public class Concatenate_Non_Zero_Digits_and_Multiply_by_Sum_I {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder("");
        // long prod = 1;
        char[] ch = s.toCharArray();
        // long res = 0;
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != '0'){
                sb.append(ch[i]);
            }
        }

        if(sb.length() == 0){
            return 0;
        }
        long curr = Long.parseLong(sb.toString());
        long sum = 0;

        long copy = curr;
        while(copy > 0){
            sum += copy % 10;
            copy = copy / 10;
        }

        return curr*sum;
    }
}
