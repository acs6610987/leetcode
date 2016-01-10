package n107_binary_tree_level_order_traversal_II;

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        if(root == null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelSize = 1, nextLevelSize = 0;
        TreeNode node;
        while(levelSize != 0){
        	List<Integer> level = new LinkedList<>();
        	nextLevelSize = 0;
        	for(int i = 0; i < levelSize; i++){
        		node = queue.poll();
        		level.add(node.val);
        		if(node.left != null){
        			queue.add(node.left);
        			nextLevelSize++;
        		}
        		if(node.right != null){
        			queue.add(node.right);
        			nextLevelSize++;
        		}
        	}
        	results.addFirst(level);
        	levelSize = nextLevelSize;
        }
        return results;
    }
}