package n64_minimum_path_sum;

public class Test {
	public static void main(String[] args){
		int[][] grid = new int[][]{
				{1, 3, 1},
				{1, 5, 1},
				{4, 2, 1}
		};
//		int[][] grid = new int[][]{
//				{0}
//		};
		System.out.println(new Solution().minPathSum(grid));
	}
}
