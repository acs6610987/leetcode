package n154_find_minimum_in_rotated_sorted_array_II;

public class Solution {
    public int findMin(int[] nums) {
    	if(nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++){
        	if(nums[(i+1)%nums.length] < nums[i%nums.length])
        		return nums[(i+1)%nums.length];
        }
        return nums[0];
    }
}
