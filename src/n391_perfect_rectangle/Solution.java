package n391_perfect_rectangle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {
	class Rectangle{
		int left, bottom, right, top;
		Rectangle(int l, int b, int r, int t){
			this.left = l;
			this.bottom = b;
			this.right = r;
			this.top = t;
		}
	}
	
	class RectangleLeftComparator implements Comparator<Rectangle>{

		@Override
		public int compare(Rectangle arg0, Rectangle arg1) {
			if(arg0.left < arg1.left) return -1;
			if(arg0.left > arg1.left) return 1;
			return 0;
		}
	}
	
	class RectangleRightComparator implements Comparator<Rectangle>{

		@Override
		public int compare(Rectangle arg0, Rectangle arg1) {
			if(arg0.right < arg1.right) return -1;
			if(arg0.right > arg1.right) return 1;
			return 0;
		}
	}
	
	class RectangleYUniqueComparator implements Comparator<Rectangle>{
		@Override
		public int compare(Rectangle arg0, Rectangle arg1){
			if(arg0.top <= arg1.bottom) return -1;
			if(arg0.bottom >= arg1.top) return 1;
			return 0;
		}
	}
	
    public boolean isRectangleCover(int[][] rectangles) {
    	int bottom = Integer.MAX_VALUE, top = Integer.MIN_VALUE,
        		left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
    	int unitNum = 0;
        Rectangle[] mRectangles = new Rectangle[rectangles.length];
        for(int i = 0; i < mRectangles.length; i++){
        	mRectangles[i] = new Rectangle(rectangles[i][0], rectangles[i][1],
        			rectangles[i][2], rectangles[i][3]);
        	if(mRectangles[i].left < left) left = mRectangles[i].left;
        	if(mRectangles[i].bottom < bottom) bottom = mRectangles[i].bottom;
        	if(mRectangles[i].right > right) right = mRectangles[i].right;
        	if(mRectangles[i].top > top) top = mRectangles[i].top;
        	unitNum += (rectangles[i][2] - rectangles[i][0]) * (rectangles[i][3] - rectangles[i][1]);
        }
        // Detect empty units, and one type of overlapping
        if(unitNum != (right - left) * (top - bottom)) return false;
        
        Arrays.sort(mRectangles, new RectangleLeftComparator());
        
        TreeSet<Rectangle> sweepLine = new TreeSet<Rectangle>(new RectangleYUniqueComparator());
        PriorityQueue<Rectangle> exitEvents = new PriorityQueue<Rectangle>(new RectangleRightComparator());
        
        // Detect another type of overlapping
        for(int i = 0; i < mRectangles.length; i++){
        	while(!exitEvents.isEmpty() && exitEvents.peek().right <= mRectangles[i].left){
        		sweepLine.remove(exitEvents.poll());
        	}
        	
        	if(sweepLine.contains(mRectangles[i]))
        		return false;
        	
        	exitEvents.add(mRectangles[i]);
        	sweepLine.add(mRectangles[i]);
        }
        
        return true;
    }
}