package burst_ballons_312;
//dynamic programming

public class Solution {
	public int maxCoins(int[] nums){
		int n = nums.length + 2;
		int[] extNums = new int[n];
		System.arraycopy(nums, 0, extNums, 1, nums.length);
		extNums[0] = extNums[n-1] = 1;
		//coins[i][j] represents the maximum coins we can collect by bursting balloons 
		//between i and j, requiring that Balloon i and Balloon j are the last two balloons we burst.
		int[][] coins = new int[n][n];
		for(int len = 1; len <= n ; len++){
			for(int i = 0; i <= n-len; i++){
				if(1 == len){
					coins[i][i] = extNums[i];
					continue;
				}
				coins[i][i+len-1] = extNums[i] + extNums[i+len-1];
				for(int k = i+1; k < i+len-1; k++){
					int tmpCoins = coins[i][k] + coins[k][i+len-1] + extNums[i]*extNums[k]*extNums[i+len-1] - 2*extNums[k];
					if(tmpCoins > coins[i][i+len-1]){
						coins[i][i+len-1] = tmpCoins;
					}
				}
			}
		}
		return coins[0][n-1] - 2;
	}
}
