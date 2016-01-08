package n74_search_a_2D_matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0) return false;
        int lBound = 0, uBound = matrix.length - 1, pivot = 0;
        while(lBound < uBound){
        	pivot = (lBound + uBound + 1) / 2;
        	if(matrix[pivot][0] < target)
        		lBound = pivot;
        	else if(matrix[pivot][0] > target)
        		uBound = pivot - 1;
        	else
        		return true;
        }
        
        int row = lBound;
        lBound = 0;
        uBound = matrix[0].length - 1;
        while(lBound <= uBound){
        	pivot = (lBound + uBound + 1) / 2;
        	if(matrix[row][pivot] < target)
        		lBound = pivot + 1;
        	else if(matrix[row][pivot] > target)
        		uBound = pivot - 1;
        	else
        		return true;
        }
        return false;
    }
}