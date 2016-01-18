package n80_remove_duplicates_from_sorted_array_II;

public class Solution {
    public int removeDuplicates(int[] nums) {
    	if(nums.length == 0) return 0;
        int nextIndex = 1, i = 1, curNum = nums[0], duplicatesAllowed = 1;
        while(i < nums.length){
        	if(nums[i] != curNum) {
        		nums[nextIndex] = nums[i];
        		curNum = nums[i];
        		duplicatesAllowed = 1;
        		nextIndex++;
        	}
        	else if(duplicatesAllowed > 0){
        		duplicatesAllowed--;
        		nums[nextIndex] = nums[i];
        		nextIndex++;
        	}
        	i++;
        }
        return nextIndex;
    }
}
