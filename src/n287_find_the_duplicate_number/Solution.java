package n287_find_the_duplicate_number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int target = 0, n = nums.length - 1, residual, expectedCount, bitCount = 0, msb = 0;
        while(n >> msb != 0) msb++;
        for(int i = 0; i < msb; i++){
        	residual = n % (1<<(i+1));
        	expectedCount = (n / (1<<(i+1)) * (1<<i)) + (residual <= ((1<<i) - 1) ? residual : ((1<<i) - 1));
        	bitCount = 0;
        	for(int x : nums){
        		if(((x>>i) & 1) == 0)
        			bitCount++;
        	}
        	if(bitCount <= expectedCount)
        		target |= (1 << i);
        }
        return target;
    }
}