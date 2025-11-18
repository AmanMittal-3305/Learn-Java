public class One_bit_and_2bit_Characters {
    public boolean isOneBitCharacter(int[] bits) {
        final int n=bits.length;
        int i=0;
        while(i<n-1){
            i+=1+bits[i];
        }
        return i==n-1;
    }
}
