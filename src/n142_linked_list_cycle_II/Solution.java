package n142_linked_list_cycle_II;

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
	/*
	 * Crypto algorithm to detect cycle
	 */
    public ListNode detectCycle(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null) return null;
        ListNode node1 = head.next, node2 = head.next.next;
        while(node1 != node2){
        	if(node1.next == null || node2.next == null || node2.next.next == null) return null;
        	node1 = node1.next;
        	node2 = node2.next.next;
        }
        node2 = head;
        while(node1 != node2){
        	node1 = node1.next;
        	node2 = node2.next;
        }
        return node1;
    }
}