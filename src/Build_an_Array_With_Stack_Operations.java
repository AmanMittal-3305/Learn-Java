import java.util.*;

public class Build_an_Array_With_Stack_Operations {
    public List<String> buildArray(int[] target, int n) {
        int i=1;
        int j=0;
        List<String> li=new ArrayList<>();
        while(j<target.length && i<=n){
            if(i!=target[j]) {
                li.add("Push");
                li.add("Pop");
            }
            else{
                li.add("Push");
                j++;
            }
            i++;
        }
        return li;
    }
}
