public class Intersection_of_Two_Arrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] seen = new boolean[1001];
        for(int num : nums1){
            seen[num] = true;
        }
        int idx = 0;
        for(int num : nums2){
            if(seen[num]){
                nums1[idx++] = num;
                seen[num] = false;
            }
        }
        int[] res = new int[idx];
        for(int i =0; i < idx; i++){
            res[i] = nums1[i];
        }
        return res;
    }
}
