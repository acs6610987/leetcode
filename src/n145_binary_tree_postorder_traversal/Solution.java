package n145_binary_tree_postorder_traversal;

import java.util.LinkedList;
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
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> traversal = new LinkedList<>();
    	if(root == null) return traversal;
        Stack<InternalNode> stack = new Stack<>();
        stack.push(new InternalNode(root, false));
        while(!stack.isEmpty()){
        	InternalNode internalNode = stack.peek();
        	if(internalNode.childrenProcessed){
        		traversal.add(internalNode.node.val);
        		stack.pop();
        		continue;
        	}
        	if(internalNode.node.right != null)
        		stack.add(new InternalNode(internalNode.node.right, false));
        	if(internalNode.node.left != null)
        		stack.add(new InternalNode(internalNode.node.left, false));
        	internalNode.childrenProcessed = true;
        }
        return traversal;
    }
    
    class InternalNode{
    	TreeNode node;
    	boolean childrenProcessed;
    	InternalNode(TreeNode n, boolean c){
    		node = n;
    		childrenProcessed = c;
    	}
    }
}