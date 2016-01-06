package n46_permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        swapPermute(nums, 0, results);
        return results;
    }
    
    private void swapPermute(int[] nums, int index, List<List<Integer>> results){
    	if(index == nums.length){
    		List<Integer> list = new ArrayList<Integer>();
    		for(int x : nums)
    			list.add(x);
    		results.add(list);
    		return;
    	}
    	int tmp = nums[index];
    	for(int i = index; i < nums.length; i++){
    		nums[index] = nums[i];
    		nums[i] = tmp;
    		swapPermute(nums, index + 1, results);
    		nums[i] = nums[index];
    	}
    	nums[index] = tmp;
    }
}