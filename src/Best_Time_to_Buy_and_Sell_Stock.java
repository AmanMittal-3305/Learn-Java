public class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int left = 0;   // buy day
        int right = 1;  // sell day
        int maxProfit = 0;

        while (right < prices.length) {
            // if profitable, calculate profit
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                // found a cheaper buy price
                left = right;
            }
            right++;
        }

        return maxProfit;
    }
}
