public class Minimum_Number_of_Flips_to_Reverse_Binary_String {
    public String binaryStr(int n){
        StringBuilder sb = new StringBuilder("");
        while(n > 0){
            sb.append(n & 1);
            n >>= 1;
        }
        return sb.reverse().toString();
    }
    public int minimumFlips(int n) {
        String str = binaryStr(n);
        String rev = new StringBuilder(str).reverse().toString();
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != rev.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
