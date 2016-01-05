package n53_maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int[] subEndSum = new int[nums.length];
        int max = subEndSum[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
        	subEndSum[i] = nums[i];
        	if(subEndSum[i-1] > 0)
        		subEndSum[i] += subEndSum[i-1];
        	if(max < subEndSum[i])
        		max = subEndSum[i];
        }
        return max;
    }
}