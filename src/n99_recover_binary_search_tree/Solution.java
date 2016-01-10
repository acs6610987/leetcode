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
 * O(n) space solution.
 */
//public class Solution {
//    public void recoverTree(TreeNode root) {
//    	if(root == null) return;
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode previous = null, current = null,
//        		mistake1 = null, mistake2 = null;
//        while(root != null || !stack.isEmpty()){
//        	
//        	while(root != null){
//        		stack.push(root);
//        		root = root.left;
//        	}
//        	current = stack.pop();
//        	if((previous != null) && (previous.val > current.val)){
//        		if(mistake1 == null)
//        			mistake1 = previous;
//        		mistake2 = current;
//        	}
//        	previous = current;
//        	root = current.right;
//        }
//        int tmp = mistake1.val;
//        mistake1.val = mistake2.val;
//        mistake2.val = tmp;
//    }
//}

/*
 * O(1) space solution. Morris traversal.
*/
public class Solution {
    public void recoverTree(TreeNode root) {
    	if(root == null) return;
        TreeNode previous = null, current = root, predecessor = null,
        		mistake1 = null, mistake2 = null;
        boolean pop = false;
        while(current != null){
        	pop = false;
        	if(current.left == null){ //if there is no predecessor, pop the current node
        		pop = true;
        	}
        	else{
        		predecessor = current.left;
        		while(predecessor.right != null && predecessor.right != current) //find the predecessor
        			predecessor = predecessor.right;
        		if(predecessor.right == null){ //(First-time visit) set the predecessor's right child to be the current node
        			predecessor.right = current;
        			current = current.left;
        		}
        		else{ //(Second-time visit) restore the predecessor's right child to NULL
        			predecessor.right = null;
        			pop = true;
        		}
        	}
        	if(pop){ //Pop the current node, and check its relationship with the previous node
        		if((previous != null) && (previous.val > current.val)){
            		if(mistake1 == null)
            			mistake1 = previous;
            		mistake2 = current;
            	}
        		previous = current;
        		current = current.right;
        	}
        }
        int tmp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = tmp;
    }
}
