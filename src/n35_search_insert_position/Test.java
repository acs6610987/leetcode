package n35_search_insert_position;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1, 3, 5, 6};
		System.out.println(new Solution().searchInsert(nums, 5));
		System.out.println(new Solution().searchInsert(nums, 2));
		System.out.println(new Solution().searchInsert(nums, 7));
		System.out.println(new Solution().searchInsert(nums, 0));
	}
}
