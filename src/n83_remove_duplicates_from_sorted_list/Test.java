package n83_remove_duplicates_from_sorted_list;

public class Test {
	public static void main(String[] args){
		ListNode node1 = new ListNode(1),
				node2 = new ListNode(1),
				node3 = new ListNode(2);
		node1.next = node2;
		node2.next = node3;
		ListNode node = new Solution().deleteDuplicates(node1);
		while(node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}
