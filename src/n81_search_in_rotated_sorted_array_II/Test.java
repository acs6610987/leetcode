package n81_search_in_rotated_sorted_array_II;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{4, 5, 5, 6, 7, 7, 7, 0, 0, 1, 2};
		System.out.println(new Solution().search(nums, 4));
		
		nums = new int[]{1, 3, 1, 1, 1};
		System.out.println(new Solution().search(nums, 3));
	}
}
