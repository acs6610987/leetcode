package n99_recover_binary_search_tree;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
**/
/*
 * O(n) space solution. O(1) solution needs Morris traversal. Writer it later.
 */
public class Solution {
    public void recoverTree(TreeNode root) {
    	if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null, current = null,
        		mistake1 = null, mistake2 = null;
        while(root != null || !stack.isEmpty()){
        	
        	while(root != null){
        		stack.push(root);
        		root = root.left;
        	}
        	current = stack.pop();
        	if((previous != null) && (previous.val > current.val)){
        		if(mistake1 == null)
        			mistake1 = previous;
        		mistake2 = current;
        	}
        	previous = current;
        	root = current.right;
        }
        int tmp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = tmp;
    }
}
