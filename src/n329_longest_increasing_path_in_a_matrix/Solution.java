package n329_longest_increasing_path_in_a_matrix;

import java.util.PriorityQueue;

public class Solution {
	
	class Cell implements Comparable<Cell>{
		int row, column, value;
		Cell(int r, int c, int v){
			row = r;
			column = c;
			value = v;
		}
		
		public int compareTo(Cell that){
			if(this.value < that.value) return -1;
			if(this.value > that.value) return 1;
			return 0;
		}
	}
	
    public int longestIncreasingPath(int[][] matrix) {
    	if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
    		return 0;
    	int m = matrix.length, n = matrix[0].length;
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
        for(int i = 0; i < m; i++)
        	for(int j = 0; j < n; j++)
        		queue.add(new Cell(i, j, matrix[i][j]));
        int longest = 0;
        int[][] lenMatrix = new int[m][n];
        while(!queue.isEmpty()){
        	Cell cell = queue.poll();
        	int tmpLongest = 1;
        	if(cell.row - 1 >= 0 && matrix[cell.row - 1][cell.column] < cell.value)
        		tmpLongest = Math.max(tmpLongest, lenMatrix[cell.row - 1][cell.column] + 1);
        	if(cell.row + 1 < m && matrix[cell.row + 1][cell.column] < cell.value)
        		tmpLongest = Math.max(tmpLongest, lenMatrix[cell.row + 1][cell.column] + 1);
        	if(cell.column - 1 >= 0 && matrix[cell.row][cell.column - 1] < cell.value)
        		tmpLongest = Math.max(tmpLongest,  lenMatrix[cell.row][cell.column - 1] + 1);
        	if(cell.column + 1 < n && matrix[cell.row][cell.column + 1] < cell.value)
        		tmpLongest = Math.max(tmpLongest, lenMatrix[cell.row][cell.column + 1] + 1);
        	lenMatrix[cell.row][cell.column] = tmpLongest;
        	longest = tmpLongest > longest ? tmpLongest : longest;
        }
        return longest;
    }
}