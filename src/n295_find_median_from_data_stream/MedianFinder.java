package n295_find_median_from_data_stream;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {

	private PriorityQueue<Integer> lowerQueue, upperQueue;
	
    /** initialize your data structure here. */
    public MedianFinder() {
        lowerQueue = new PriorityQueue<Integer>(new GreaterComparator());
        upperQueue = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
    	if(lowerQueue.isEmpty()) lowerQueue.add(num);
    	else if(upperQueue.isEmpty() || lowerQueue.size() > upperQueue.size()) { 
    		// lower queue size is bigger than upper queue size by 1
    		if(num >= lowerQueue.peek()) upperQueue.add(num); 
    		else {
    			upperQueue.add(lowerQueue.poll());
    			lowerQueue.add(num);
    		}
    	}
    	else { // lower queue and upper queue has the same size
    		if(num <= lowerQueue.peek()) lowerQueue.add(num);
    		else if (num <= upperQueue.peek()) lowerQueue.add(num);
    		else {
    			lowerQueue.add(upperQueue.poll());
    			upperQueue.add(num);
    		}
    	}
    	
    }
    
    public double findMedian() {
    	if(lowerQueue.isEmpty())
    		return 0;
        if(lowerQueue.size() > upperQueue.size())
        	return lowerQueue.peek();
        return (lowerQueue.peek() + upperQueue.peek()) * 1.0 / 2;
    }
    
    class GreaterComparator implements Comparator<Integer>{
    	public int compare(Integer a, Integer b){
    		if((int)a > (int)b) return -1;
    		if((int)a < (int)b) return 1;
    		return 0;
    	}
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */ 