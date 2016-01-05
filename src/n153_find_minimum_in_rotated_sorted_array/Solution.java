package n153_find_minimum_in_rotated_sorted_array;

public class Solution {
    public int findMin(int[] nums) {
        for(int i = 0; i < nums.length; i++){
        	if(nums[(i+1)%nums.length] <= nums[i%nums.length])
        		return nums[(i+1)%nums.length];
        }
        return 0;
    }
}
