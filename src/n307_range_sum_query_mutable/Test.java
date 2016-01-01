package n307_range_sum_query_mutable;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1, 3, 5};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		numArray.update(1, 2);
		System.out.println(numArray.sumRange(0, 2));
	}
}