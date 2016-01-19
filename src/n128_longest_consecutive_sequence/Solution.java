package n128_longest_consecutive_sequence;

import java.util.HashMap;

public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> visits = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        	visits.put(nums[i], false);
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
        	if(visits.get(nums[i])) continue;
        	visits.put(nums[i], true);
        	int curLen = 1, element = nums[i] + 1;
        	while(visits.containsKey(element)){
        		visits.put(element++, true);
        		curLen++;
        	}
        	element = nums[i] - 1;
        	while(visits.containsKey(element)){
        		visits.put(element--, true);
        		curLen++;
        	}
        	if(curLen > maxLen)
        		maxLen = curLen;
        }
        return maxLen;
    }
}
