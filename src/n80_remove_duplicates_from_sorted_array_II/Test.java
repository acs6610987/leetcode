package n80_remove_duplicates_from_sorted_array_II;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[] {1, 1,2};
		int len = new Solution().removeDuplicates(nums);
		for(int i = 0; i < len; i++)
			System.out.print(nums[i] + ", ");
		System.out.println();
		
		nums = new int[]{1,2,3,3,4};
		len = new Solution().removeDuplicates(nums);
		for(int i = 0; i < len; i++)
			System.out.print(nums[i] + ", ");
		System.out.println();
		
		nums = new int[]{1};
		len = new Solution().removeDuplicates(nums);
		for(int i = 0; i < len; i++)
			System.out.print(nums[i] + ", ");
		System.out.println();
		
		nums = new int[]{1, 1, 1, 2, 2, 3};
		len = new Solution().removeDuplicates(nums);
		for(int i = 0; i < len; i++)
			System.out.print(nums[i] + ", ");
		System.out.println();
	}
}
