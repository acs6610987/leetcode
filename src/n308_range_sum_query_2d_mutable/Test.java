package n308_range_sum_query_2d_mutable;

public class Test {
	public static void main(String[] args){
		int[][] matrix = {
				 {3, 0, 1, 4, 2},
				 {5, 6, 3, 2, 1},
				 {1, 2, 0, 1, 5},
				 {4, 1, 0, 1, 7},
				 {1, 0, 3, 0, 5}
		};
		
		NumMatrix nm = new NumMatrix(matrix);
		System.out.println(nm.sumRegion(2, 1, 4, 3));
		nm.update(3, 2, 2);
		System.out.println(nm.sumRegion(2, 1, 4, 3));
	}
}
