package n142_linked_list_cycle_II;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    
    @Override
    public String toString(){
    	return val + "";
    }
}