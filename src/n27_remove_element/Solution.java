package n27_remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
        	while(left <= right && nums[left] != val) left++;
        	while(left <= right && nums[right] == val) right--;
        	if(left <= right)
        		nums[left++] = nums[right--];
        }
        return right + 1;
    }
}