package n51_N_queens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	StringBuffer rowString = new StringBuffer();
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> configs = new ArrayList<>();
        for(int i = 0; i < n; i++)
        	rowString.append('.');
        int[] queens = new int[n];
        configure(n, 0, queens, configs);
        return configs;
    }
    
    public void configure(int n, int nextRow, int[] queens, List<List<String>> configs){
    	if(nextRow == n){
    		List<String> sol = new ArrayList<>();
    		for(int i = 0; i < n; i++){
    			rowString.setCharAt(queens[i], 'Q');
    			sol.add(rowString.toString());
    			rowString.setCharAt(queens[i], '.');
    		}
    		configs.add(sol);
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
    		configure(n, nextRow+1, queens, configs);
    	}
    }
}
