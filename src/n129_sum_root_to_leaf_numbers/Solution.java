package n129_sum_root_to_leaf_numbers;

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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode root, int cur){
    	int sum = 0;
    	if(root.left == null && root.right == null)
    		sum = cur*10 + root.val;
    	if(root.left != null)
    		sum += sumNumbers(root.left, cur*10 + root.val);
    	if(root.right != null)
    		sum += sumNumbers(root.right, cur*10 + root.val);
    	return sum;
    }
}