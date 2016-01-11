package n162_find_peak_element;

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1 || nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
    	int left = 1, right = nums.length - 2, pivot;
        while(left < right - 1){
        	pivot = (left + right) / 2;
        	boolean biggerThanLeft = nums[pivot] > nums[pivot - 1],
        			biggerThanRight = nums[pivot] > nums[pivot + 1];
        	if(biggerThanLeft && biggerThanRight)
        		return pivot;
        	if(biggerThanLeft)
        		left = pivot;
        	else if(biggerThanRight)
        		right = pivot;
        	else
        		right = pivot - 1;
        }
        if(left == right) return left;
        if(nums[left] < nums[right]) return right;
        return left;
    }
}
