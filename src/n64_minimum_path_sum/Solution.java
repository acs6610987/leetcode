package n64_minimum_path_sum;

public class Solution {
    public int minPathSum(int[][] grid) {
    	if(grid.length == 0) return 0;
        int[][] pathSum = new int[2][grid[0].length];
        int i, j;
        for(i = 0; i < grid.length; i++){
        	int current = i % 2, prev = (i + 1) % 2;
        	pathSum[current][0] = pathSum[prev][0] + grid[i][0];
        	for(j = 1; j < grid[0].length; j++){
        		pathSum[current][j] = pathSum[current][j-1];
        		if(i > 0 && pathSum[prev][j] < pathSum[current][j-1])
        			pathSum[current][j] = pathSum[prev][j];
        		pathSum[current][j] += grid[i][j];
        	}
        }
        return pathSum[(i+1)%2][grid[0].length - 1];
    }
}