package n330_patching_array;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1, 3};
		System.out.println(new Solution().minPatches(nums, 6));
		 
		nums = new int[]{1, 5, 10};
		System.out.println(new Solution().minPatches(nums, 20));
		
		nums = new int[]{1, 2, 2};
		System.out.println(new Solution().minPatches(nums, 5));
	}
}
