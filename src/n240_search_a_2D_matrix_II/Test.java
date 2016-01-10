package n240_search_a_2D_matrix_II;

public class Test {
	public static void main(String[] args){
//		int[][] matrix = new int[][]{
//				{1, 4, 7, 11, 15},
//				{2, 5, 8, 12, 19},
//				{3, 6, 9, 16, 22},
//				{10, 13, 14, 17, 24},
//				{18, 21, 23, 26, 30}
//		};
//		int[][] matrix = new int[][]{
//				{-1},
//				{-1}
//		};
		int[][] matrix = new int[][]{
				{1, 3, 5, 7, 9},
				{2, 4, 6, 8, 10},
				{11, 13, 15, 17, 19},
				{12, 14, 16, 18, 20},
				{21, 22, 23, 24, 25}
		};
		System.out.println(new Solution().searchMatrix(matrix, 11));
	}
}
