package n75_sort_colors;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{2, 1};
		new Solution().sortColors(nums);
		for(int i = 0; i < nums.length; i++)
			System.out.println(nums[i] + ", ");
	}
}
