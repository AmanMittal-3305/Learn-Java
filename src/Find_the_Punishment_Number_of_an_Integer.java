public class Find_the_Punishment_Number_of_an_Integer {
    // Step 1: Function to check if n^2 can be partitioned into numbers summing to n
    public static boolean canPartition(String num, int target, int start)
    {
        // Step 1.1: If all digits are used and sum equals n, return true
        if (start == num.length())
        {
            return target == 0;
        }

        int sum = 0;
        for (int i = start; i < num.length(); i++)
        {
            // Step 1.2: Form a number from substring
            sum = sum * 10 + (num.charAt(i) - '0');

            // Step 1.3: Stop early if sum exceeds target
            if (sum > target)
            {
                break;
            }

            // Step 1.4: If partition found, return true
            if (canPartition(num, target - sum, i + 1))
            {
                return true;
            }
        }

        // Step 1.5: Return false if no valid partition exists
        return false;
    }

    // Step 2: Function to check if n^2 can be partitioned correctly
    public static boolean hasSubarraySum(int n)
    {
        int square = n * n;
        return canPartition(String.valueOf(square), n, 0);
    }

    // Step 3: Function to calculate punishment number recursively
    public int punishmentNumber(int n)
    {
        // Step 3.1: Base case, return 0
        if (n == 0)
        {
            return 0;
        }

        // Step 3.2: Check if n satisfies the condition
        int addValue = hasSubarraySum(n) ? (n * n) : 0;

        // Step 3.3: Recursive call to process all numbers
        return addValue + punishmentNumber(n - 1);
    }
}
