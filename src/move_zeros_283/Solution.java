package move_zeros_283;

public class Solution {
    public void moveZeroes(int[] nums) {
    	if(nums.length == 0) return;
        int available = 0, i = 0;
        while(available < nums.length && nums[available] != 0){
        	available++;
        	i++;
        }
        while(i < nums.length){
        	if(nums[i] != 0){
        		nums[available] = nums[i];
        		available++;
        	}
        	i++;
        }
        while(available < nums.length)
        	nums[available++] = 0;
    }
}
