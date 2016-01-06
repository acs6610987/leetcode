package n21_merge_two_sorted_list;

public class Test {
	public static void main(String[] args){
		ListNode node1 = new ListNode(1), node2 = new ListNode(2),
				node3 = new ListNode(3), node4 = new ListNode(4);
		node2.next = node3;
		node3.next = node4;
		ListNode head = new Solution().mergeTwoLists(node1, node2);
		while(head != null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
