package n141_linked_list_cycle;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode node = head;
        while(node.next != null){
        	if(node.next == head)
        		return true;
        	ListNode tmp = node.next;
        	node.next = head;
        	node = tmp;
        }
        return false;
    }
}