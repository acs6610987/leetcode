package n317_shortest_distance_from_all_buildings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestDistance(int[][] grid) {
    	if(null == grid || 0 == grid.length || 0 == grid[0].length)
    		return -1;
        int buildings = 0, m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		if(grid[i][j] == 1) buildings++;
        int minDist = -1;
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++){
        		if(grid[i][j] != 0) continue;
        		int visitedBuildings = 0;
        		Queue<Integer> bfs = new LinkedList<Integer>();
        		boolean[][] visited = new boolean[m][n];
        		bfs.add(i * n + j);
        		visited[i][j] = true;
        		int tmpMinDist = 0, singleDist = 0;
        		while(!bfs.isEmpty()){
        			int size = bfs.size();
        			for(int k = 0; k < size; k++){
        				int coordinate = bfs.poll(), row = coordinate / n, column = coordinate % n;
        				if(grid[row][column] == 1){
        					visitedBuildings++;
        					tmpMinDist += singleDist;
        					if(minDist != -1 && tmpMinDist > minDist){
        						bfs.clear();
        						break;
        					}
        					continue;
        				}
        				if(grid[row][column] == 2) continue;
        				if(row - 1 >= 0 && !visited[row - 1][column]) {
        					bfs.add((row-1)*n + column);
        					visited[row-1][column] = true;
        				}
        				if(row + 1 < m && !visited[row + 1][column]) {
        					bfs.add((row+1)*n + column);
        					visited[row+1][column] = true;
        				}
        				if(column - 1 >= 0 && !visited[row][column - 1]) {
        					bfs.add(row*n + column - 1);
        					visited[row][column-1] = true;
        				}
        				if(column + 1 < n && !visited[row][column + 1]) {
        					bfs.add(row*n + column + 1);
        					visited[row][column+1] = true;
        				}
        			}
        			singleDist++;
        		}
        		if(visitedBuildings == buildings && (minDist == -1 || tmpMinDist < minDist))
        			minDist = tmpMinDist;
        	}
        
        return minDist;
    }
}