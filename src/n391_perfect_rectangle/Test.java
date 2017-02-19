package n391_perfect_rectangle;

public class Test {
	public static void main(String[] args){
		int[][] rectangles = new int[][]{
				{1,1,3,3},
				{3,1,4,2},
				{3,2,4,4},
				{1,3,2,4},
				{2,3,3,4}
		};
		System.out.println(new Solution().isRectangleCover(rectangles));
		
		rectangles = new int[][]{
				{1, 1, 2, 3},
				{1, 3, 2, 4},
				{3, 1, 4, 2},
				{3, 2, 4, 4}
		};
		System.out.println(new Solution().isRectangleCover(rectangles));
		
		rectangles = new int[][]{
				{1, 1, 3, 3},
				{3, 1, 4, 2},
				{1, 3, 2, 4},
				{3, 2, 4, 4}
		};
		System.out.println(new Solution().isRectangleCover(rectangles));
		
		rectangles = new int[][]{
				{1, 1, 3, 3},
				{3, 1, 4, 2},
				{1, 3, 2, 4},
				{2, 2, 4, 4}
		};
		System.out.println(new Solution().isRectangleCover(rectangles));
	}
}
