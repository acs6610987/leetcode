package n240_search_a_2D_matrix_II;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0 || matrix[0].length == 0
    			|| matrix[0][0] > target 
    			|| matrix[matrix.length - 1][matrix[0].length - 1] < target ) return false;
    	int lBound = 0, uBound = matrix.length < matrix[0].length? matrix.length - 1 : matrix[0].length - 1, pivot = 0;
    	while(lBound < uBound){
    		pivot = (lBound + uBound + 1) / 2;
    		if(matrix[pivot][pivot] < target)
    			lBound = pivot;
    		else if(matrix[pivot][pivot] > target)
    			uBound = pivot - 1;
    		else
    			return true;
    	}
    	
    	int index = lBound;
    	uBound = matrix[0].length - 1;
    	while(lBound <= uBound){
    		pivot = (lBound + uBound + 1) / 2;
    		if(matrix[index][pivot] < target)
    			lBound = pivot + 1;
    		else if(matrix[index][pivot] > target)
    			uBound = pivot - 1;
    		else
    			return true;
    	}
    	
    	lBound = index;
    	uBound = matrix.length - 1;
    	while(lBound <= uBound){
    		pivot = (lBound + uBound + 1) / 2;
    		if(matrix[pivot][index] < target)
    			lBound = pivot + 1;
    		else if (matrix[pivot][index] > target)
    			uBound = pivot - 1;
    		else
    			return true;
    	}
    	return false;
    }
    
    private boolean searchBoundedMatrix(int[][] matrix, int top, int bottom, int left, int right, int target){
    	if(top > bottom)
    	int lBound = 0, uBound = matrix.length < matrix[0].length? matrix.length - 1 : matrix[0].length - 1, pivot = 0;
    	while(lBound < uBound){
    		pivot = (lBound + uBound + 1) / 2;
    		if(matrix[pivot][pivot] < target)
    			lBound = pivot;
    		else if(matrix[pivot][pivot] > target)
    			uBound = pivot - 1;
    		else
    			return true;
    	}
    }
}
