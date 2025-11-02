public class Lexicographically_Smallest_String_After_Reverse {
    public String lexSmallest(String s) {
        char[] c = s.toCharArray();
        char minc='z', maxc='a';
        for(char x:c){
            if(minc>x)minc=x;
            if(maxc<x)maxc=x;
        }
        if(minc==maxc)return s;
        char[] a=s.toCharArray(), t;
        for(int i=0; i<c.length-1; i++){
            if(c[i]==minc){
                first(a, c, i);
            }
            if(c[i]>=c[c.length-1]){
                second(a, c, i);
            }
        }
        return new String(a);
    }
    private void first(char[] a, char[] c, int x){
        boolean change=false;
        for(int i=0; i<=x && !change; i++){
            if(a[i]<c[x-i])return;
            else if(a[i]>c[x-i])change=true;
        }
        for(int i=x+1; i<c.length && !change; i++){
            if(a[i]<c[i])return;
            else if(a[i]>c[i])change=true;
        }
        if(change){
            for(int i=0; i<=x; i++)a[i]=c[x-i];
            for(int i=x+1; i<c.length; i++)a[i]=c[i];
        }
    }
    private void second(char[] a, char[] c, int x){
        boolean change=false;
        for(int i=0; i<x && !change; i++){
            if(a[i]<c[i])return;
            else if(a[i]>c[i])change=true;
        }
        for(int i=x; i<c.length && !change; i++){
            if(a[i]<c[c.length-1-(i-x)])return;
            else if(a[i]>c[c.length-1-(i-x)])change=true;
        }
        if(change){
            for(int i=0; i<x; i++)a[i]=c[i];
            for(int i=x; i<c.length; i++)a[i]=c[c.length-1-(i-x)];
        }
    }
}
