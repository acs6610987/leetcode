package n173_binary_search_tree_iterator;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	Stack<TreeNode> inOrderTraversal = new Stack<>();
    public BSTIterator(TreeNode root) {
        while(root != null){
        	inOrderTraversal.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !inOrderTraversal.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = inOrderTraversal.pop(), root = node.right;
        while(root != null){
        	inOrderTraversal.push(root);
        	root = root.left;
        }
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */