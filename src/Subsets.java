import java.util.*;

public class Subsets {
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int i){
        if (i == nums.length) {
            res.add(new ArrayList<>(list));  // add a copy
            return;
        }

        // Exclude current element
        helper(nums, res, list, i + 1);

        // Include current element
        list.add(nums[i]);
        helper(nums, res, list, i + 1);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums, res, list, 0);
        return res;
    }
}
