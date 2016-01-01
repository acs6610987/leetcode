package move_zeros_283;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{0, 1, 0, 3, 12};
		new Solution().moveZeroes(nums);
		for(int x : nums)
			System.out.print(x + ", ");
	}
}
