package n238_product_of_array_except_self;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[]{};
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++)
        	output[i] = output[i-1] * nums[i-1];
        for(int i = nums.length - 2; i >= 0; i--)
        	nums[i] = nums[i] * nums[i+1];
        for(int i = 0; i < nums.length - 1; i++)
        	output[i] = output[i] * nums[i+1];
        return output;
    }
}