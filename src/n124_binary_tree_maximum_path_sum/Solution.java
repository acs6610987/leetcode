package n124_binary_tree_maximum_path_sum;

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
	private int maxSum = 0;
	
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum = root.val;
        int left = maxPathSumStartFrom(root.left);
        int right = maxPathSumStartFrom(root.right);
        int sum = root.val;
    	if(left > 0) sum += left;
    	if(right > 0) sum += right;
    	if(maxSum < sum) maxSum = sum;
    	return maxSum;
    }
    
    private int maxPathSumStartFrom(TreeNode root){
    	if(root == null) return 0;
    	int left = maxPathSumStartFrom(root.left);
    	int right = maxPathSumStartFrom(root.right);
    	int sum = root.val;
    	if(left > 0) sum += left;
    	if(right > 0) sum += right;
    	if(maxSum < sum) maxSum = sum;
    	return left > 0 ? 
    			(left > right ? root.val + left : root.val + right) 
    			: (right > 0 ? root.val + right : root.val);
    }
}