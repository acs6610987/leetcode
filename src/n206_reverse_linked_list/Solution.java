package n206_reverse_linked_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, current = head;
        while(current != null){
        	ListNode tmp = current.next;
        	current.next = prev;
        	prev = current;
        	current = tmp;
        }
        return prev;
    }
}
