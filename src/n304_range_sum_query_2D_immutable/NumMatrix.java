package n304_range_sum_query_2D_immutable;

public class NumMatrix {
	private int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
    	if(matrix.length == 0) return;
        sumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
        for(int i = 0; i < sumMatrix.length; i++)
        	for(int j = 0; j < sumMatrix[0].length; j++){
        		if(i == 0 || j == 0) sumMatrix[i][j] = 0;
        		else
        			sumMatrix[i][j] = matrix[i-1][j-1] + sumMatrix[i-1][j] + sumMatrix[i][j-1] - sumMatrix[i-1][j-1];
        	}
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumMatrix[row2 + 1][col2 + 1] - sumMatrix[row1][col2 + 1] - sumMatrix[row2 + 1][col1] + sumMatrix[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
