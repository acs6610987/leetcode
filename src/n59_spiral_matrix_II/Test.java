package n59_spiral_matrix_II;

public class Test {
	public static void main(String[] args){
		int[][] matrix = new Solution().generateMatrix(0);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
