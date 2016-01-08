package n48_rotate_image;

public class Test {
	public static void main(String[] args){
//		int[][] matrix = new int[][]{
//				{1, 2, 3},
//				{4,5,6},
//				{7,8,9}
//		};
		int[][] matrix = new int[][]{
				{1, 2},
				{3, 4}
		};
		new Solution().rotate(matrix);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++)
				System.out.print(matrix[i][j] + ",");
			System.out.println();
		}
	}
}
