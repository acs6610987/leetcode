package n117_populating_next_right_pointers_in_each_node_II;


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
        TreeLinkNode head = root, previous = null, dummy = new TreeLinkNode(0);
        while(head != null){
        	while(head!= null && head.left == null && head.right == null) head = head.next;
        	if(head == null) return;
        	previous = dummy;
        	while(head != null){
        		if(head.left != null){
        			previous.next = head.left;
        			previous = previous.next;
        		}
        		if(head.right != null){
        			previous.next = head.right;
        			previous = previous.next;
        		}
        		head = head.next;
        	}
        	previous.next = null;
        	head = dummy.next;
        }
    }
}