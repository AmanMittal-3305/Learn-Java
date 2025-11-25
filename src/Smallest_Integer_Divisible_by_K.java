public class Smallest_Integer_Divisible_by_K {
    public int smallestRepunitDivByK(int k) {
        if ( (k&1)==0|| k%5==0) return -1;
        if (k==1) return 1;
        int r=1;
        for(int len0=2; ; len0++){
            r=(10*r+1)%k;
            if (r==0) return len0;
        }
    }
}
