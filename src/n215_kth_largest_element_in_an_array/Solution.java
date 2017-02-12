package n215_kth_largest_element_in_an_array;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        
    }
    
    private int findKthLargetsInRange(int[] nums, int lBound, int rBound, int k){
    	
    }
    
    private int partition(int[] nums, int lBound, int rBound){
    	int tmp = nums[lBound];
    	while(true){
    		while(rBound > lBound && nums[rBound] > tmp) rBound++;
    		if(rBound > lBound) nums[lBound] = nums[rBound];
    	}
    }
}