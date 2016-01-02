package n52_N_queens_II;

public class Solution {
	int counter = 0;
	public int totalNQueens(int n) {
		int[] queens = new int[n];
        configure(n, 0, queens);
        return counter;
    }
    
    public void configure(int n, int nextRow, int[] queens){
    	if(nextRow == n){
    		counter++;
    		return;
    	}
    	for(int i = 0; i < n; i++){
    		boolean available = true;
    		for(int j = 0; j < nextRow; j++){
    			if(i == queens[j] || (i-queens[j] == nextRow-j) || (i-queens[j] == j-nextRow)){
    				available = false;
    				break;
    			}
    		}
    		if(!available) continue;
    		queens[nextRow] = i;
    		configure(n, nextRow+1, queens);
    	}
    }
}
