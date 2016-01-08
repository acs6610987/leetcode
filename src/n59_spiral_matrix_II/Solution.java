package n59_spiral_matrix_II;

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
    	int[][] steps = new int[][]{
        	{0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int[] limits = new int[]{0, n-1, n-1, 0};
        int[] pos = new int[]{0, 0};
        int direction = 0;
        for(int i = 1; i <= n*n; i++){
        	matrix[pos[0]][pos[1]] = i;
        	if(pos[direction%2] == limits[direction] && pos[(direction+1)%2] == limits[(direction+1)%4]){
        		limits[direction] += (steps[(direction+1)%4][0] + steps[(direction+1)%4][1]);
        		direction = (direction+1)%4;
        	}
        	pos[0] += steps[direction][0];
        	pos[1] += steps[direction][1];
        }
        return matrix;
    }
}
