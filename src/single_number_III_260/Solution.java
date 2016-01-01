package single_number_III_260;

public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 0) return null;
        int xXORy = xor(nums);
        int i = 0;
        while((xXORy & (1<<i)) == 0) i++;
        for(int j = 0; j < nums.length; j++)
        	if((nums[j] & (1<<i)) == 0)
        		nums[j] = 0;
        int x = xor(nums);
        return new int[]{x, x^xXORy};
    }
    
    public int xor(int[] nums){
    	int result = 0;
    	for(int i = 0; i < nums.length; i++)
    		result ^= nums[i];
    	return result;
    }
}