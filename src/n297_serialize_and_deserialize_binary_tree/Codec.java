package n297_serialize_and_deserialize_binary_tree;

import java.util.LinkedList;
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null)
    		return "x";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuffer result = new StringBuffer();
        result.append(root.val);
        while(!queue.isEmpty()){
        	TreeNode next = queue.poll();
        	result.append(',');
        	if(next.left != null){
        		queue.add(next.left);
        		result.append(next.left.val);
        	}
        	else
        		result.append('x');
        	result.append(',');
        	if(next.right != null){
        		queue.add(next.right);
        		result.append(next.right.val);
        	}
        	else
        		result.append('x');
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeStrs = data.split(",");
        if(nodeStrs.length == 1 && nodeStrs[0].equals("x"))
        	return null;
        TreeNode root = new TreeNode(Integer.valueOf(nodeStrs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int strInd = 1;
        while(!queue.isEmpty()){
        	int size = queue.size();
        	for(int i = 0; i < size; i++){
        		TreeNode node = queue.poll();
        		TreeNode left = nodeStrs[strInd].equals("x") ? null : new TreeNode(Integer.valueOf(nodeStrs[strInd])),
        				right = nodeStrs[strInd + 1].equals("x") ? null : new TreeNode(Integer.valueOf(nodeStrs[strInd + 1]));
        		node.left = left;
        		node.right = right;
        		if(null != left) queue.add(left);
        		if(null != right) queue.add(right);
        		strInd += 2;
        	}
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));