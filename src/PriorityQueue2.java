import java.util.*;

public class PriorityQueue2 {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //Add at last index
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par, temp);
                x = par;
                par = (x-1)/2;
            }
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.add(5);
        h.add(2);
        h.add(7);
        h.add(1);

        System.out.println(h.arr);
    }
}
