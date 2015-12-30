package range_sum_query_immutable_303;

public class NumArray {
	private int[] sumInclusive, sumExclusive;
    public NumArray(int[] nums) {
    	if(nums.length == 0) return;
    	sumInclusive = new int[nums.length];
    	sumExclusive = new int[nums.length];
    	sumInclusive[0] = nums[0];
    	sumExclusive[0] = 0;
        for(int i = 1; i < nums.length; i++){
        	sumInclusive[i] = sumInclusive[i-1] + nums[i];
        	sumExclusive[i] = sumExclusive[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sumInclusive[j] - sumExclusive[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);