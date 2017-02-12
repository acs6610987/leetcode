package n239_sliding_window_maximum;

public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k){
		if(null == nums || 0 == nums.length)
			return new int[0];
		
		int[] dominateLen = new int[nums.length];
		dominateLen[dominateLen.length - 1] = 1;
		for(int i = nums.length - 2; i >= 0; i--){
			if(nums[i] > nums[i+1])
				dominateLen[i] = dominateLen[i+1] + 1;
			else
				dominateLen[i] = 1;
		}
		
		int[] windowMax = new int[nums.length - k + 1];
		for(int i = 0; i <= nums.length - k; i++){
			int tmp = k, maxIndex = i;
			while(dominateLen[i] < tmp){
				maxIndex
			}
		}
		
		return windowMax;
	}

}
