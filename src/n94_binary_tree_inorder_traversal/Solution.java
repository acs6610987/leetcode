package n94_binary_tree_inorder_traversal;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(null == root) return new ArrayList<Integer>();
        List<Integer> visits = new ArrayList<>();
        Stack<VisitTuple> traversal = new Stack<>();
        traversal.push(new VisitTuple(root, false));
        while(!traversal.isEmpty()){
        	VisitTuple tuple = traversal.pop();
        	if(tuple.leftVisited)
        		visits.add(tuple.node.val);
        	else{
        		if(tuple.node.right != null)
        			traversal.push(new VisitTuple(tuple.node.right, false));
        		tuple.leftVisited = true;
        		traversal.push(tuple);
        		if(tuple.node.left != null)
        			traversal.push(new VisitTuple(tuple.node.left, false));
        	}
        }
        return visits;
    }
    
    class VisitTuple{
    	TreeNode node;
    	boolean leftVisited;
    	VisitTuple(TreeNode n, boolean v){
    		node = n;
    		leftVisited = v;
    	}
    }
}
