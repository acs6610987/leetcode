package n298_binary_tree_longest_consecutive_sequence;

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
    public int longestConsecutive(TreeNode root) {
    	if(root == null)
    		return 0;
    	return traverse(root, 0);
    }
    
    private int traverse(TreeNode root, int curLen){
    	curLen++;
    	int maxLen = curLen, leftMax = 0, rightMax = 0;
    	if(root.left != null){
    		if(root.val + 1 == root.left.val && root.val < root.left.val)
    			leftMax = traverse(root.left, curLen);
    		else
    			leftMax = traverse(root.left, 0);
    	}
    	if(root.right != null){
    		if(root.val + 1 == root.right.val && root.val < root.right.val)
    			rightMax = traverse(root.right, curLen);
    		else
    			rightMax = traverse(root.right, 0);
    	}
    	maxLen = Math.max(maxLen, leftMax);
    	maxLen = Math.max(maxLen, rightMax);
    	return maxLen;
    }
}