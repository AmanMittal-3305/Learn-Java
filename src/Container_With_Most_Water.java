public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxWater = 0;
        while(l < r){
            int ht = Math.min(height[l], height[r]);
            int wt = r-l;
            int currWater = ht * wt;
            maxWater = Math.max(maxWater, currWater);
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return maxWater;
    }
}
