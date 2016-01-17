package n199_binary_tree_right_side_view;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode node;
        queue.add(root);
        while(!queue.isEmpty()){
        	int currentSize = queue.size();
        	for(int i = 0; i < currentSize - 1; i++){
        		node = queue.poll();
        		if(node.left != null) queue.add(node.left);
        		if(node.right != null) queue.add(node.right);
        	}
        	node = queue.poll();
        	list.add(node.val);
        	if(node.left != null) queue.add(node.left);
    		if(node.right != null) queue.add(node.right);
        }
        return list;
    }
}