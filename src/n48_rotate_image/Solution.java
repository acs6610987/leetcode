package n48_rotate_image;

public class Solution {
    public void rotate(int[][] matrix) {
        int layer = 0, n = matrix.length;
        while(layer <= (n - 1) / 2){
        	for(int i = 0; i < n - 2*layer - 1; i++){
        		int taken = matrix[layer][layer+i];
        		matrix[layer][layer+i] = matrix[n-layer-i-1][layer];
        		matrix[n-layer-i-1][layer] = matrix[n-layer-1][n-layer-i-1];
        		matrix[n-layer-1][n-layer-i-1] = matrix[layer+i][n-layer-1];
        		matrix[layer+i][n-layer-1] = taken;
        	}
        	layer++;
        }
    }
}
