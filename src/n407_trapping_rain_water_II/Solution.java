package n407_trapping_rain_water_II;

import java.util.LinkedList;
import java.util.Queue;

// This solution doesn't work. Cannot derive from the one-dimension problem.
public class Solution {
    public int trapRainWater(int[][] heightMap) {
    	if(null == heightMap || 0 == heightMap.length || 0 == heightMap[0].length)
    		return 0;
        int[][] trapRowMap = new int[heightMap.length][heightMap[0].length],
        		trapColumnMap = new int[heightMap.length][heightMap[0].length],
        		trapMap = new int[heightMap.length][heightMap[0].length];
        for(int i = 0; i < heightMap.length; i++)
        	trapRow(heightMap, trapRowMap, i);
        for(int j = 0; j < heightMap[0].length; j++)
        	trapColumn(heightMap, trapColumnMap, j);
        int barVolume = 0, totalVolume = 0;
        for(int i = 0; i < heightMap.length; i++)
        	for(int j = 0; j < heightMap[0].length; j++){
        		barVolume += heightMap[i][j];
        		trapMap[i][j] = Math.min(trapRowMap[i][j], trapColumnMap[i][j]);
        	}
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        for(int i = 0; i < heightMap.length; i++)
        	for(int j = 0; j < heightMap[0].length; j++){
        		if(trapMap[i][j] > heightMap[i][j] && !visited[i][j]){
        			Queue<Integer> connected = new LinkedList<>();
        			int minWater = bfsMinWater(heightMap, trapMap, visited, i, j, connected);
        			while(!connected.isEmpty()){
        				int x = connected.poll();
        				trapMap[x / heightMap[0].length][x % heightMap[0].length] = Math.max(minWater, 
        						heightMap[x / heightMap[0].length][x % heightMap[0].length]);
        			}
        		}
        		totalVolume += trapMap[i][j];
        	}
        
        return totalVolume - barVolume;
    }
    
    // O(m)
    private void trapRow(int[][] heightMap, int[][] trapHeightMap, int row){
    	int left = 0, right = heightMap[0].length - 1, trapHeight = 0;
    	while(left < right){
    		trapHeightMap[row][left] = heightMap[row][left];
        	trapHeightMap[row][right] = heightMap[row][right];
    		if(heightMap[row][left] <= heightMap[row][right]){
    			trapHeight = trapHeightMap[row][left];
    			while(left < right && trapHeight >= heightMap[row][left])
    				trapHeightMap[row][left++] = trapHeight;
    		}
    		else{
    			trapHeight = trapHeightMap[row][right];
    			while(left < right && trapHeight >= heightMap[row][right])
    				trapHeightMap[row][right--] = trapHeight;
    		}
    	}
    	trapHeightMap[row][left] = heightMap[row][left];
    }
    // O(n)
    private void trapColumn(int[][] heightMap, int[][] trapHeightMap, int column){
    	int left = 0, right = heightMap.length - 1, trapHeight = 0;
    	while(left < right){
    		trapHeightMap[left][column] = heightMap[left][column];
        	trapHeightMap[right][column] = heightMap[right][column];
    		if(heightMap[left][column] <= heightMap[right][column]){
    			trapHeight = trapHeightMap[left][column];
    			while(left < right && trapHeight >= heightMap[left][column])
    				trapHeightMap[left++][column] = trapHeight;
    		}
    		else{
    			trapHeight = trapHeightMap[right][column];
    			while(left < right && trapHeight >= heightMap[right][column])
    				trapHeightMap[right--][column] = trapHeight;
    		}
    	}
    	trapHeightMap[left][column] = heightMap[left][column];
    }
    
    private int bfsMinWater(int[][] heightMap, int[][] trapMap, boolean[][] visited, 
    		int row, int column, Queue<Integer> connected){
    	visited[row][column] = true;
    	if(trapMap[row][column] <= heightMap[row][column])
    		return trapMap[row][column];
    	connected.add(row * heightMap[0].length + column);
    	int minWater = trapMap[row][column];
    	if(row - 1 >= 0 && !visited[row-1][column])
    		minWater = Math.min(minWater, bfsMinWater(heightMap, trapMap, visited, row-1, column, connected));
    	if(row + 1 < heightMap.length && !visited[row+1][column])
    		minWater = Math.min(minWater, bfsMinWater(heightMap, trapMap, visited, row+1, column, connected));
    	if(column-1 >= 0 && !visited[row][column-1])
    		minWater = Math.min(minWater, bfsMinWater(heightMap, trapMap, visited, row, column-1, connected));
    	if(column+1 < heightMap[0].length && !visited[row][column + 1])
    		minWater = Math.min(minWater, bfsMinWater(heightMap, trapMap, visited, row, column+1, connected));
    	return minWater;
    }
}