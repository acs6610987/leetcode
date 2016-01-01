package single_number_III_260;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1, 2, 1, 3, 2, 5};
		int[] singles = new Solution().singleNumber(nums);
		System.out.println(singles[0] + ", " + singles[1]);
	}
}
