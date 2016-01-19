package n81_search_in_rotated_sorted_array_II;

public class Solution {
    public boolean search(int[] nums, int target) {
    	if(nums.length == 0) return false;
        int left = 0, right = nums.length - 1, middle = 0, pivot = 0;
        //search for the pivot
        pivot = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
        	if(nums[(i+1)%nums.length] < nums[i%nums.length]){
        		pivot = i;
        		break;
        	}
        }
        if(nums[0] <= target){
        	if(nums[pivot] < target) return false;
        	left = 0;
        	right = pivot;
        }
        else{
        	left = pivot + 1;
        	right = nums.length - 1;
        }
        //search for the target
        while(left <= right){
        	middle = (left + right) / 2;
        	if(nums[middle] < target)
        		left = middle + 1;
        	else if(nums[middle] > target)
        		right = middle - 1;
        	else
        		return true;
        }
        return false;
    }
}
