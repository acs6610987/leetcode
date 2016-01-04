package n116_populating_next_right_pointers_in_each_node;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(null == root) return;
        TreeLinkNode node = root;
        while(node.left != null){
        	node.left.next = node.right;
        	TreeLinkNode linkNode = node;
        	while(linkNode.next != null){
        		linkNode.right.next = linkNode.next.left;
        		linkNode = linkNode.next;
        		linkNode.left.next = linkNode.right;
        	}
        	node = node.left;
        }
    }
}
