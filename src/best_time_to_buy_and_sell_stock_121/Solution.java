package best_time_to_buy_and_sell_stock_121;

/*
 * Equivalent to the problem of maximum length of increasing subsequence
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int prevMax = 0, max = 0;
        for(int i = 1; i < prices.length; i++){
        	if(prevMax > 0)
        		prevMax += prices[i] - prices[i-1];
        	else
        		prevMax = prices[i] - prices[i-1];
        	if(max < prevMax)
        		max = prevMax;
        }
        return max;
    }
}