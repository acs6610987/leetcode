package n329_longest_increasing_path_in_a_matrix;

public class Test {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
				{9, 9, 4},
				{6, 6, 8},
				{2, 1, 1}
		};
		System.out.println(new Solution().longestIncreasingPath(matrix));
		
		matrix = new int[][]{
				{3, 4, 5},
				{3, 2, 6},
				{2, 2, 1}
		};
		System.out.println(new Solution().longestIncreasingPath(matrix));
	}
}
