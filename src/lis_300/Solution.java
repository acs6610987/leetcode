package lis_300;

public class Solution {
    public int lengthOfLIS(int[] nums) {
    	int[] lenEnd = new int[nums.length];
    	int maxLen = 0;
    	for(int i = 0; i < nums.length; i++){
    		lenEnd[i] = 1;
    		for(int j = 0; j < i; j++){
    			if(nums[j] < nums[i] && lenEnd[j] + 1 > lenEnd[i])
    				lenEnd[i] = lenEnd[j] + 1;
    		}
    		if(maxLen < lenEnd[i])
    			maxLen = lenEnd[i];
    	}
        return maxLen;
    }
}