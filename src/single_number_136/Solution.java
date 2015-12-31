package single_number_136;

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        nums[1] = nums[1] ^ nums[0];
        for(nums[0] = 2; nums[0] < nums.length; nums[0]++)
        	nums[nums[0]] = nums[nums[0]] ^ nums[nums[0] - 1];
        return nums[nums.length - 1];
    }
}
