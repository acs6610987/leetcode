package n237_delete_node_in_linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node.next == null){
        	node = null;
        	return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}