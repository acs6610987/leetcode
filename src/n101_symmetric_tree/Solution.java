package n101_symmetric_tree;

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 * Recursive
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if(root == null) return true;
    	if(!(root.left == null && root.right == null))
    		return isLevelSymmetric(new TreeNode[]{root.left, root.right});
    	return true;
    }
    
    private boolean isLevelSymmetric(TreeNode[] nodes){
    	LinkedList<TreeNode> nextLevel = new LinkedList<>();
    	for(int i = nodes.length / 2 - 1, j = nodes.length / 2; i >= 0; i--, j++){
    		if((nodes[i] == null && nodes[j] != null)
    				|| (nodes[i] != null && nodes[j] == null)
    				|| nodes[i].val != nodes[j].val) return false;
    		if(!(nodes[i].right == null && nodes[j].left == null)){
    			nextLevel.addFirst(nodes[i].right);
    			nextLevel.addLast(nodes[j].left);
    		}
    		if(!(nodes[i].left == null && nodes[j].right == null)){
    			nextLevel.addFirst(nodes[i].left);
    			nextLevel.addLast(nodes[j].right);
    		}
    	}
    	if(nextLevel.size() == 0) return true;
    	nodes = new TreeNode[nextLevel.size()];
    	nextLevel.toArray(nodes);
    	return isLevelSymmetric(nodes);
    }
}