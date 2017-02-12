package n330_patching_array;

public class Solution {
	/*
	 * The algorithm constructs the sum from 1 to n.
	 * i points to the first element that has not been used so far in nums.
	 * [0, curMax] denotes we can construct the range of sums from 0 to curMax by using elements nums[0...i-1] and the minimum num of patches.
	 * And curMax should be the sum of nums[0...i-1] and patches.
	 * In the next step, we want to construct the sum curMax+1
	 * 1. If nums[i] <= curMax+1, then we can construct the sum from curMax+1 to curMax+nums[i] without adding any patch.
	 * Hence we can construct the sum range [0, curMax+nums[i]] by using elements nums[0...i] and the minimum num of patches. (Why is it min)
	 */
    public int minPatches(int[] nums, int n) {
        int i = 0, curMax = 0, patches = 0;
        while(curMax < n){
        	if(i < nums.length && nums[i] <= curMax + 1){
        		curMax += nums[i];
        		i++;
        	}
        	else{
        		curMax += curMax + 1;
        		patches++;
        	}
        }
        return patches;
    }
}