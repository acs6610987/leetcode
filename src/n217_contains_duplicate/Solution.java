package n217_contains_duplicate;

import java.util.Hashtable;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Hashtable<Integer, Integer> numCount = new Hashtable<>();
        for(int i = 0; i < nums.length; i++){
        	if(numCount.containsKey(nums[i]))
        		return true;
        	numCount.put(nums[i], 1);
        }
        return false;
    }
}