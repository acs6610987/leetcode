package n315_count_of_smaller_numbers_after_self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	class Number implements Comparable<Number>{
		int value, index;
		Number(int v, int i){
			value = v;
			index = i;
		}
		
		@Override
		public int compareTo(Number that){
			if(this.value < that.value) return -1;
			if(this.value > that.value) return 1;
			return 0;
		}
	}
	
    public List<Integer> countSmaller(int[] nums) {
    	if(null == nums) return new ArrayList<Integer>();
        int n = nums.length;
        Number[] indexNums = new Number[n];
        for(int i = 0; i < n; i++)
        	indexNums[i] = new Number(nums[i], i);
        Arrays.sort(indexNums);
        
        int[] BIT = new int[n + 1];
        Integer[] counts = new Integer[n];
        for(int i = 0; i < n; i++){
        	counts[indexNums[i].index] = getSum(BIT, n - indexNums[i].index - 2);
        	set(BIT, n - indexNums[i].index - 1);
        }
        return Arrays.asList(counts);
    }
    
    private void set(int[] BIT, int i){
    	for(int j = i + 1; j < BIT.length; j += (j & -j))
    		BIT[j] += 1;
    }
    
    private int getSum(int[] BIT, int i){
    	int sum = 0;
    	for(int k = i + 1; k > 0; k -= (k & -k))
    		sum += BIT[k];
    	return sum;
    }
    
}