package n240_search_a_2D_matrix_II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    	int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
    	while(left <= right && top <= bottom){
    		if(right - left > bottom - top){
    			int pos = searchRow(matrix, top, left, right, target);
    			if(pos == -1) return true;
    			right = pos - 1;
    			top++;
    		}
    		else{
    			int pos = searchColumn(matrix, left, top, bottom, target);
    			if(pos == -1) return true;
    			bottom = pos - 1;
    			left++;
    		}
    	}
    	return false;
    }
    
    private int searchRow(int[][] matrix, int row, int left, int right, int target){
    	int pivot;
    	while(left < right){
    		pivot = (left + right + 1) / 2;
    		if(matrix[row][pivot] < target)
    			left = pivot;
    		else if(matrix[row][pivot] > target)
    			right = pivot - 1;
    		else
    			return -1;
    	}
    	if(matrix[row][left] < target) return left + 1;
    	else if(matrix[row][left] > target) return left;
    	return -1;
    }
    
    private int searchColumn(int[][] matrix, int column, int top, int bottom, int target){
    	int pivot;
    	while(top < bottom){
    		pivot = (top + bottom + 1) / 2;
    		if(matrix[pivot][column] < target)
    			top = pivot;
    		else if(matrix[pivot][column] > target)
    			bottom = pivot - 1;
    		else
    			return -1;
    	}
    	if(matrix[top][column] < target) return top + 1;
    	else if(matrix[top][column] > target) return top;
    	return -1;
    }
}
