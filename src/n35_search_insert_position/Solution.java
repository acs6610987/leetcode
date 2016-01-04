package n35_search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int lowerBound = 0, upperBound = nums.length - 1, pos = (lowerBound + upperBound) / 2;
        while(nums[pos] != target){
        	if(nums[pos] > target){
        		if(pos - 1 < 0 || nums[pos - 1] < target)
        			return pos;
        		upperBound = pos - 1;        
        	}
        	if(nums[pos] < target){
        		if(pos + 1 >= nums.length || nums[pos + 1] > target)
        			return pos + 1;
        		lowerBound = pos + 1;
        	}
        	pos = (upperBound + lowerBound) / 2;
        }
        return pos;
    }
}
