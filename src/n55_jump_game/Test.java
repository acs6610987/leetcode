package n55_jump_game;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{2,3 , 1, 1, 4};
		System.out.println(new Solution().canJump(nums));
		nums = new int[]{3, 2, 1, 0, 4};
		System.out.println(new Solution().canJump(nums));
	}
}
