package n83_remove_duplicates_from_sorted_list;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while(current != null){
        	while(current.next != null && current.val == current.next.val)
        		current.next = current.next.next;
        	current = current.next;
        }
        return head;
    }
}