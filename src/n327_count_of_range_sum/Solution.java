package n327_count_of_range_sum;

import java.util.Arrays;

public class Solution {
	
	class HeadSumNode implements Comparable<HeadSumNode>{
		long sum;
		int index;
		HeadSumNode(long s, int i){
			sum = s;
			index = i;
		}
		@Override
		public int compareTo(HeadSumNode x){
			if(this.sum < x.sum) return -1;
			if(this.sum > x.sum) return 1;
			return 0;
		}
	}
	
    public int countRangeSum(int[] nums, int lower, int upper) {
    	if(null == nums || 0 == nums.length) return 0;
    	int n = nums.length, total = 0;
    	long[] headSum = new long[n];
    	HeadSumNode[] headSumNodes = new HeadSumNode[n];
    	for(int i = 0; i < n; i++){
    		if(i == 0) headSum[i] = nums[0];
    		else headSum[i] = headSum[i-1] + nums[i];
    		headSumNodes[i] = new HeadSumNode(headSum[i], i);
    	}
    	Arrays.sort(headSumNodes);
    	int[] newIndices = new int[n];
    	for(int i = 0; i < n; i++)
    		newIndices[headSumNodes[i].index] = i;
    	
    	int[] BIT = new int[n+1];
    	for(int i = 0; i < n; i++)
    		update(BIT, i, true);
    	
    	// L <= S[i,j] = S[j] - S[i-1] <= U
    	// ==> L + S[i-1] <= S[j] <= U + S[i-1]
    	for(int i = 0; i < n; i++){
    		long lValue = i==0? lower : lower + headSum[i-1],
    			uValue = i==0? upper : upper + headSum[i-1];
    		int lIndex = getCeilingIndex(headSumNodes, lValue),
    			uIndex = getFloorIndex(headSumNodes, uValue);
    		if(lIndex != -1 && uIndex != -1)
    			total += getRangeSize(BIT, lIndex, uIndex);
    		update(BIT, newIndices[i], false);
    	}
    	
        return total;
    }
    
    private void update(int[] BIT, int i, boolean set){
    	int diff = set ? 1 : -1;
    	for(int j = i + 1; j < BIT.length; j += (j & -j))
    		BIT[j] += diff;
    }
    
    private int getRangeSize(int[] BIT, int start, int end){
    	int sum = 0;
    	for(int i = start; i > 0; i -= (i & -i))
    		sum -= BIT[i];
    	for(int i = end + 1; i > 0; i -= (i & -i))
    		sum += BIT[i];
    	return sum;
    }
    
    private int getCeilingIndex(HeadSumNode[] sortedNodes, long value){
    	int left = 0, right = sortedNodes.length - 1;
    	int result = -1;
    	while(left <= right){
    		int middle = (left + right) / 2;
    		if(sortedNodes[middle].sum >= value){
    			result = middle;
    			right = middle - 1;
    		}
    		else{
    			left = middle + 1;
    		}
    	}
    	return result;
    }
    
    private int getFloorIndex(HeadSumNode[] sortedNodes, long value){
    	int left = 0, right = sortedNodes.length - 1;
    	int result = -1;
    	while(left <= right){
    		int middle = (left + right) / 2;
    		if(sortedNodes[middle].sum <= value){
    			result = middle;
    			left = middle + 1;
    		}
    		else{
    			right = middle - 1;
    		}
    	}
    	return result;
    }
}

