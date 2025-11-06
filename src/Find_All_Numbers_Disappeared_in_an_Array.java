import java.util.ArrayList;
import java.util.List;

public class Find_All_Numbers_Disappeared_in_an_Array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // Mark numbers as negative using the value as index
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // convert to zero-based index
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Collect numbers whose indices are positive (not marked)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // convert back to 1-based number
            }
        }

        return result;
    }
}
