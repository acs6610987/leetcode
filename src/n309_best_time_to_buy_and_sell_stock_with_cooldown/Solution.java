package n309_best_time_to_buy_and_sell_stock_with_cooldown;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int maxProfit(int[] prices) {
        List<Transaction> possibleTrans = new ArrayList<>();
        for(int i = 0; i < prices.length - 1; i++){
        	int buy = i;
        	while(i < prices.length - 1 && prices[i] < prices[i + 1]) i++;
        	if(i == buy) continue;
        	possibleTrans.add(new Transaction(prices, buy, i));
        }
        if(possibleTrans.size() == 0) return 0;
        
        int[][] dpProfits = new int[possibleTrans.size()][4];
        int maxProfit = 0, i = 0;
        Transaction prev = null, current = possibleTrans.get(0);
        dpProfits[0][0] = current.profits[0];
        dpProfits[0][1] = current.profits[1];
        dpProfits[0][2] = current.profits[2];
        dpProfits[0][3] = current.profits[3];
        for(i = 1; i < possibleTrans.size(); i++){
        	prev = possibleTrans.get(i - 1);
        	current = possibleTrans.get(i);
        	int maxKeepPrevSell = max(dpProfits[i-1][0], dpProfits[i-1][1]),
        			maxChangePrevSell = max(dpProfits[i-1][2], dpProfits[i-1][3]);
        	dpProfits[i][1] = current.profits[1] + maxKeepPrevSell;
        	dpProfits[i][3] = current.profits[3] + maxKeepPrevSell;
        	if(current.buyDay - prev.sellDay == 1){
        		dpProfits[i][0] = max(current.profits[0] + maxChangePrevSell,  //change previous sell day
        				current.profits[0] + maxKeepPrevSell + prices[current.buyDay] - prices[prev.sellDay]);  //or merge two transactions
        		dpProfits[i][2] = max(current.profits[2] + maxChangePrevSell,
        				current.profits[2] + maxKeepPrevSell + prices[current.buyDay] - prices[prev.sellDay]);
        	}
        	else{
        		dpProfits[i][0] = current.profits[0] + maxKeepPrevSell;
        		dpProfits[i][2] = current.profits[2] + maxKeepPrevSell;
        	}
        }
        maxProfit = max(max(dpProfits[i-1][0], dpProfits[i-1][1]), max(dpProfits[i-1][2], dpProfits[i-1][3]));
        return maxProfit;
    }
    
    private int max(int a, int b){
    	return a > b? a : b;
    }
    
    class Transaction{
    	int buyDay;
    	int sellDay;
    	int[] profits = new int[4];
    	Transaction(int[] prices, int b, int s){
    		buyDay = b;
    		sellDay = s;
    		profits[0] = prices[s] - prices[b]; //hold stock from day b to day s
    		profits[1] = prices[s] - prices[b + 1]; //hold stock from day b+1 to day s
    		profits[2] = prices[s - 1] - prices[b]; //hold stock from day b to day s-1
    		profits[3] = (s - b == 1) ? 0 : (prices[s - 1] - prices[b + 1]); //hold stock from day b+1 to day s-1
    	}
    }
}