package n57_insert_interval;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> merged = new LinkedList<>();
        ListIterator<Interval> it = intervals.listIterator();
        Interval cur = null;
        while(it.hasNext()){
        	cur = it.next();
        	if(cur.end < newInterval.start)
        		merged.add(cur);
        	else break;
        }
        
        if(cur == null || cur.end < newInterval.start){
        	merged.add(newInterval);
        	return merged;
        }
        
        int start = Math.min(cur.start, newInterval.start),
        		end = newInterval.end;
        
        while(true){
        	if(cur.end >= newInterval.end){
        		if(cur.start <= newInterval.end)
        			end = cur.end;
        		break;
        	}
        	if(!it.hasNext()) break;
        	cur = it.next();
        }
        
        merged.add(new Interval(start, end));
        if(cur.start > newInterval.end)
        	merged.add(cur);
        while(it.hasNext())
        	merged.add(it.next());
        return merged;
    }
}