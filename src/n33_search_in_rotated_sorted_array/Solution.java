package n33_search_in_rotated_sorted_array;

public class Solution {
    public int search(int[] nums, int target) {
    	if(nums.length == 0) return -1;
        int left = 0, right = nums.length - 1, middle = 0, pivot = 0;
        //search for the pivot
        while(left < right){
        	middle = (left + right) / 2;
        	if(nums[middle] > nums[left])
        		left = middle;
        	else if(nums[middle] < nums[left])
        		right = middle - 1;
        	else if(nums[left] > nums[right])
        		right = left;
        	else
        		left = right;
        }
        pivot = left;
        if(nums[0] <= target){
        	if(nums[pivot] < target) return -1;
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
        		return middle;
        }
        return -1;
    }
}
