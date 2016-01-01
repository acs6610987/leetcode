package n304_range_sum_query_2D_immutable;

public class Test {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}
		};
		 NumMatrix numMatrix = new NumMatrix(matrix);
		 System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
		 System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
	}
}
