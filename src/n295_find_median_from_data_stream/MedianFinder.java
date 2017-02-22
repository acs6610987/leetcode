package n295_find_median_from_data_stream;

import java.util.PriorityQueue;

public class MedianFinder {

	private PriorityQueue<Integer> lowerQueue, upperQueue;
	
    /** initialize your data structure here. */
    public MedianFinder() {
        lowerQueue = new PriorityQueue<Integer>();
        upperQueue = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        
    }
    
    public double findMedian() {
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */