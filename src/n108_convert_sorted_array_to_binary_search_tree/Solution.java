package n108_convert_sorted_array_to_binary_search_tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return arrayRangeToBST(nums, 0, nums.length - 1);
    }
    
    public TreeNode arrayRangeToBST(int[] nums, int start, int end){
    	if(start > end) return null;
    	if(start == end) return new TreeNode(nums[start]);
    	TreeNode root = new TreeNode(nums[(start+end)/2]);
    	root.left = arrayRangeToBST(nums, start, (start+end)/2 - 1);
    	root.right = arrayRangeToBST(nums, (start+end)/2 + 1, end);
    	return root;
    }
}