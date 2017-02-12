package n460_lfu_cache;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class LFUCache {

	class CacheItem{
		int key;
		int value;
		int freq;
		public CacheItem(int k, int v, int f){
			key = k;
			value = v;
			freq = f;
		}
	}
	
	private int capacity;
	/* The cache for looking up. */
	private Hashtable<Integer, CacheItem> cache;
	/* Maintain a list of items for each frequency. */
	private Hashtable<Integer, Queue<CacheItem>> freqTable;
	
    public LFUCache(int capacity) {
    	this.capacity = capacity;
        this.cache = new Hashtable<Integer, CacheItem>();
        this.freqTable = new Hashtable<Integer, Queue<CacheItem>>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key) || 0 == capacity)
        	return -1;
        CacheItem item = cache.get(key);
        item.freq += 1;
        if(!freqTable.containsKey(item.freq)){
        	freqTable.put(item.freq, new LinkedList<CacheItem>());
        }
        freqTable.get(item.freq).add(item);
        /* Note that "item" still exists in the previous frequency list, but we delay the deletion of it in "put". */
        return item.value;
    }
    
    public void put(int key, int value) {
    	if(0 == capacity)
    		return;
    	/* If the key already exists, it is easy. */
        if(cache.containsKey(key)){
        	CacheItem item = cache.get(key);
        	item.value = value;
        	cache.put(key, item);
        	get(key);
        }
        else{
        	CacheItem item = new CacheItem(key, value, 1);
        	/* First we need to make space for the new item. */
    		if(cache.size() >= capacity){
	    		int i = 1;
	    		/* Although this is a while loop, the amortized cost is still O(1). See analysis in the comments. */
	    		while(true){
	    			/* We search up to the least frequency list. This cost will be amortized to "get" operations. For example, if we need to go up to i = 10000, then it means there were at least 10000 "get" operations before this "put" operation. */
	    			while(!freqTable.containsKey(i) || freqTable.get(i).isEmpty()) 
	    				i++; 
	    			Queue<CacheItem> queue = freqTable.get(i);
	    			while(!queue.isEmpty() && queue.peek().freq > i)
	    				queue.poll(); /* Lazy deletion. This cost will be amortized to the corresponding "get" operation. */
	    			if(queue.isEmpty())
	    				continue;
	    			CacheItem evicted = queue.poll();
    				cache.remove(evicted.key);
    				break;
	    		}
    		}
    		if(!freqTable.containsKey(1)){
    			freqTable.put(1,  new LinkedList<CacheItem>());
    		}
    		freqTable.get(1).add(item);
    		cache.put(key, item);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */