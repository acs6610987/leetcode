package n303_range_sum_query_immutable;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		System.out.println(numArray.sumRange(2, 5));
	}
}
