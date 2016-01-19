package n102_binary_tree_level_order_traversal;

import java.util.ArrayList;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> results = new LinkedList<>();
    	if(root == null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
        	int curSize = queue.size();
        	List<Integer> level = new ArrayList<>(curSize);
        	for(int i = 0; i < curSize; i++){
        		TreeNode node = queue.poll();
        		level.add(node.val);
        		if(node.left != null)
        			queue.add(node.left);
        		if(node.right != null)
        			queue.add(node.right);
        	}
        	results.add(level);
        }
        return results;
    }
}