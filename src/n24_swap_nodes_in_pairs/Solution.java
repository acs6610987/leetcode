package n24_swap_nodes_in_pairs;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0), prev = dummy, current = head;
        dummy.next = head;
        while(current != null && current.next != null){
        	prev.next = current.next;
        	current.next = current.next.next;
        	prev.next.next = current;
        	
        	prev = current;
        	current = current.next;
        }
        return dummy.next;
    }
}