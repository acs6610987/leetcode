package n21_merge_two_sorted_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	if(l2 == null) return l1;
    	ListNode head = l1.val <= l2.val ? l1 : l2;
    	ListNode prev = null;
        while(l1 != null && l2 != null){
        	prev = null;
        	while(l1 != null && l1.val <= l2.val) {
        		prev = l1;
        		l1 = l1.next;
        	}
        	if(prev != null) prev.next = l2;
        	if(l1 == null) break;
        	prev = null;
        	while(l2 != null && l1.val >= l2.val){
        		prev = l2;
        		l2 = l2.next;
        	}
        	if(prev != null) prev.next = l1;
        }
        return head;
    }
}