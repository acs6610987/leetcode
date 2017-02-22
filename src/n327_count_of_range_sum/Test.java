package n327_count_of_range_sum;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{-2, 5, -1};
		int lower = -2, upper = 2;
		System.out.println(new Solution().countRangeSum(nums, lower, upper));
		
		nums = new int[]{0, -1, -2, -3, 0, 2};
		lower = 3;
		upper = 5;
		System.out.println(new Solution().countRangeSum(nums, lower, upper));
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		nums = new int[]{-2147483647,0,-2147483647,2147483647};
		lower = -564;
		upper = 3864;
		System.out.println(new Solution().countRangeSum(nums, lower, upper));
	}
}
