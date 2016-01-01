package n226_invert_binary_tree;

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
    public TreeNode invertTree(TreeNode root) {
    	if(null == root) return null;
    	TreeNode right = invertTree(root.left);
    	TreeNode left = invertTree(root.right);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}