package n74_search_a_2D_matrix;

public class Test {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
//		int[][] matrix = new int[][]{
//				{1}
//		};
		System.out.println(new Solution().searchMatrix(matrix, 17));
	}
}
