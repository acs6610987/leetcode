package n73_set_matrix_zeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
    	int row = -1, column = -1, tmp;
    	for(int i = 0; i < matrix.length; i++){
    		for(int j = 0; j < matrix[0].length; j++){
    			if(i == row || j == column)
    				matrix[i][j] = matrix[i][j] == 0 ? 0 : 1;
    			else if(matrix[i][j] == 0){
    				if(row == -1){
	    				row = i;
	    				column = j;
	    				tmp = 0;
	    				while(tmp < i) matrix[tmp++][j] = 1;
	    				tmp = 0;
	    				while(tmp < j) matrix[i][tmp++] = 1;
    				}
    				matrix[i][column] = matrix[row][j] = 0;
    			}
    		}
    	}
    	if(row >= 0){
			for(int i = 0; i < matrix.length; i++){
				if(i == row) continue;
				if(matrix[i][column] == 0){
					tmp = 0;
					while(tmp < matrix[0].length) matrix[i][tmp++] = 0;
				}
				matrix[i][column] = 0;
			}
			for(int j = 0; j < matrix[0].length; j++){
				if(matrix[row][j] == 0){
					tmp = 0;
					while(tmp < matrix.length) matrix[tmp++][j] = 0;
				}
				matrix[row][j] = 0;
			}
    	}
    }
}
