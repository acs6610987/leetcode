package n169_majority_element;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, guess = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(count == 0){
        		guess = nums[i];
        		count = 1;
        	}
        	else if(guess == nums[i])
        		count++;
        	else
        		count--;
        }
        return guess;
    }
}