package n26_remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums.length == 0) return 0;
        int nextIndex = 1, i = 1, curNum = nums[0];
        while(i < nums.length){
        	if(nums[i] != curNum) {
        		nums[nextIndex] = nums[i];
        		curNum = nums[i];
        		nextIndex++;
        	}
        	i++;
        }
        return nextIndex;
    }
}