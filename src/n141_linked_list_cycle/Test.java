package n141_linked_list_cycle;

public class Test {
	public static void main(String[] args){
		ListNode node1 = new ListNode(1), node2 = new ListNode(2),
				node3 = new ListNode(3), node4 = new ListNode(4);
		System.out.println(new Solution().hasCycle(null));
		System.out.println(new Solution().hasCycle(node1));
		node1.next = node2;
		node2.next = node3;
		System.out.println(new Solution().hasCycle(node1));
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2;
		System.out.println(new Solution().hasCycle(node1));
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node3;
		System.out.println(new Solution().hasCycle(node1));
	}
}
