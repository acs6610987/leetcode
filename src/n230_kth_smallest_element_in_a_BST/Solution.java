package n230_kth_smallest_element_in_a_BST;

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
	int number = 0, order = 0;
    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root, k);
        return number;
    }
    
    private void inOrderTraversal(TreeNode root, int k){
    	if(root == null) return;
    	inOrderTraversal(root.left, k);
    	order += 1;
    	if(order == k){
    		number = root.val;
    		return;
    	}
    	inOrderTraversal(root.right, k);
    }
}
