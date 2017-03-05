package n146_LRU_cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	class ListNode{
		int key, value;
		ListNode next, previous;
		ListNode(int key, int value){
			this.key = key;
			this.value = value;
			next = previous = null;
		}
	}
	
	Map<Integer, ListNode> cache;
	ListNode head, tail;
	int capacity;
	
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = tail = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        ListNode node = cache.get(key);
        if(head != node){
	        node.previous.next = node.next;
	        if(tail != node)
	        	node.next.previous = node.previous;
	        else
	        	tail = node.previous;
	        node.next = head;
	        node.previous = null;
	        head.previous = node;
	        head = node;
        }
        return node.value;
    }
    
    public void put(int key, int value) {
    	if(capacity == 0) return;
        if(cache.containsKey(key)){
        	cache.get(key).value = value;
        	get(key);
        }
        else{
        	if(cache.size() >= capacity){
        		cache.remove(tail.key);
        		if(tail.previous != null)
        			tail.previous.next = null;
        		tail = tail.previous;
        	}
        	ListNode newHead = new ListNode(key, value);
        	newHead.next = head;
        	if(head != null)
        		head.previous = newHead;
        	head = newHead;
        	if(tail == null)
        		tail = head;
        	cache.put(key, newHead);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
