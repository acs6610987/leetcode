package n54_spiral_matrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> spiralList = new ArrayList<>();
    	if(matrix.length == 0) return spiralList;
    	int m = matrix.length, n = matrix[0].length, direction = 0;
    	int[][] steps = new int[][]{
        	{0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        int[] limits = new int[]{0, n-1, m-1, 0};
        int[] pos = new int[]{0, 0};
        for(int i = 1; i <= m*n; i++){
        	spiralList.add(matrix[pos[0]][pos[1]]);
        	if(pos[direction%2] == limits[direction] && pos[(direction+1)%2] == limits[(direction+1)%4]){
        		limits[direction] += (steps[(direction+1)%4][0] + steps[(direction+1)%4][1]);
        		direction = (direction+1)%4;
        	}
        	pos[0] += steps[direction][0];
        	pos[1] += steps[direction][1];
        }
        return spiralList;
    }
}