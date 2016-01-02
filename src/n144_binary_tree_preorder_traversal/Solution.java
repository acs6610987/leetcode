package n144_binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
    	if(null == root) return new ArrayList<Integer>();
        List<Integer> visits = new ArrayList<>();
        Stack<TreeNode> traversal = new Stack<>();
        traversal.push(root);
        while(!traversal.isEmpty()){
        	TreeNode node = traversal.pop();
        	visits.add(node.val);
        	if(node.right != null)
        		traversal.push(node.right);
        	if(node.left != null)
        		traversal.push(node.left);
        }
        return visits;
    }
}