import java.util.*;

public class Find_All_Duplicates_in_an_Array {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int flipIdx = Math.abs(nums[i]) - 1;
            if(nums[flipIdx] < 0){
                res.add(Math.abs(nums[i]));
            }
            nums[flipIdx] *= -1;
        }

        return res;
    }
}
