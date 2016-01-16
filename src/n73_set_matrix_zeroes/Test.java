package n73_set_matrix_zeroes;

public class Test {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
				{1, 2, 3, 4, 5},
				{3, 4, 5, 0, 5},
				{5, 5, 0, 5, 5},
				{5, 5, 0, 5, 0}
		};
		new Solution().setZeroes(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + ", ");
			System.out.println();
		}
		
		matrix = new int[][]{
				{1}
		};
		new Solution().setZeroes(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + ", ");
			System.out.println();
		}
			
	}
}
