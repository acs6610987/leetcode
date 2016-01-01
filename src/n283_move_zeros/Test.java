package n283_move_zeros;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{0, 1, 0, 3, 12};
		new Solution().moveZeroes(nums);
		for(int x : nums)
			System.out.print(x + ", ");
	}
}
