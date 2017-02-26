package n163_missing_ranges;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new LinkedList<>();
        if(null == nums || 0 == nums.length){
        	addRange(ranges, lower, upper);
        	return ranges;
        }
        if(nums[0] != lower)
        	addRange(ranges, lower, nums[0] - 1);
        int i = 1;
        while(i < nums.length){
        	if(nums[i] == nums[i-1] || nums[i] == nums[i-1] + 1)
        		i++;
        	else{
        		addRange(ranges, nums[i-1] + 1, nums[i] - 1);
        		i++;
        	}
        }
        if(nums[i-1] != upper)
        	addRange(ranges, nums[i-1] + 1, upper);
        return ranges;
    }
    
    private void addRange(List<String> ranges, int from, int to){
    	if(from == to)
    		ranges.add(String.valueOf(from));
    	else
    		ranges.add(String.valueOf(from) + "->" + String.valueOf(to));
    }
}