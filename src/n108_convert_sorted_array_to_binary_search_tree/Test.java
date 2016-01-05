package n108_convert_sorted_array_to_binary_search_tree;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[] {10, 30, 49, 50, 67, 78};
		TreeNode root = new Solution().sortedArrayToBST(nums);
		System.out.println(root.val);
	}

}
