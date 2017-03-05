package n57_insert_interval;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args){
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(4, 9);
		List<Interval> merged = new Solution().insert(intervals, newInterval);
		
		for(int i = 0; i < merged.size(); i++)
			System.out.print("[" + merged.get(i).start + ", " + merged.get(i).end + "], ");
		System.out.println();
		
		intervals = new ArrayList<>();
		intervals.add(new Interval(5, 8));
		merged = new Solution().insert(intervals, newInterval);
		
		for(int i = 0; i < merged.size(); i++)
			System.out.print("[" + merged.get(i).start + ", " + merged.get(i).end + "], ");
		System.out.println();
		
		intervals = new ArrayList<>();
		intervals.add(new Interval(1, 5));
		newInterval = new Interval(0, 0);
		merged = new Solution().insert(intervals, newInterval);
		
		for(int i = 0; i < merged.size(); i++)
			System.out.print("[" + merged.get(i).start + ", " + merged.get(i).end + "], ");
		System.out.println();
	}
}
