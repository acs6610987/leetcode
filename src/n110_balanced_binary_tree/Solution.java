package n110_balanced_binary_tree;

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
	private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root);
        return balanced;
    }
    
    private int getDepth(TreeNode root){
    	if(root == null) return 0;
    	int leftHeight = getDepth(root.left);
    	int rightHeight= getDepth(root.right);
    	if(leftHeight - rightHeight > 1 || leftHeight - rightHeight < -1) 
    		balanced = false;
    	return (leftHeight > rightHeight? leftHeight : rightHeight) + 1;
    }
}
