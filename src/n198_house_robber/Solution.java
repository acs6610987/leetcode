package n198_house_robber;

public class Solution {
    public int rob(int[] nums) {
    	if(nums == null || nums.length == 0) return 0;
    	if(nums.length == 1) return nums[0];
    	int[] money = new int[nums.length];
    	int maxMoney = 0;
    	money[0] = nums[0];
    	maxMoney = money[1] = nums[0] > nums[1] ? nums[0] : nums[1];
    	for(int i = 2; i < nums.length; i++){
    		money[i] = money[i-1] > money[i-2] + nums[i] ? money[i-1] : money[i-2] + nums[i];
    		if(money[i] > maxMoney)
    			maxMoney = money[i];
    	}
    	return maxMoney;
    }
}