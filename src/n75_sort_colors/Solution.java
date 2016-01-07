package n75_sort_colors;

public class Solution {
    public void sortColors(int[] nums) {
    	if(nums == null || nums.length == 0) return;
        int order = 0;
        for(int color = 0; color < 2; color++){
        	while(order < nums.length && nums[order] == color) order++;
        	for(int i = order; i < nums.length; i++){
        		if(nums[i] == color){
        			nums[i] = nums[order];
        			nums[order] = color;
        			order++;
        		}
        	}
        }
    }
}