package n212_word_search_II;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Hashtable<String, Boolean> prefixSet = new Hashtable<String, Boolean>();
        for(int i = 0; i < words.length; i++){
        	for(int j = 0; j < words[i].length(); j++){
        		String sub = words[i].substring(0,  j+1);
        		if(j == words[i].length() - 1)
        			prefixSet.put(words[i], true);
        		else if(!prefixSet.containsKey(sub))
        			prefixSet.put(words[i].substring(0, j + 1), false);
        	}
        }
        Set<String> result = new HashSet<String>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++)
        	for(int j = 0; j < board[i].length; j++){
        		StringBuffer buf = new StringBuffer();
        		buf.append(board[i][j]);
        		visited[i][j] = true;
        		dfs(board, i, j, buf, visited, prefixSet, result);
        		visited[i][j] = false;
        	}
        return new LinkedList<String>(result);
    }
    
    private void dfs(char[][] board, int row, int column, StringBuffer currentPrefix,
    		boolean[][] visited, Hashtable<String, Boolean> prefixSet, Set<String> result){
    	String term = currentPrefix.toString();
    	if(!prefixSet.containsKey(term))
    		return;
    	if(prefixSet.get(term) == true){
    		result.add(term);
    	}
    	int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    	for(int i = 0; i < direction.length; i++){
    		int nextRow = row + direction[i][0], nextColumn = column + direction[i][1];
    		if(nextRow >= 0 && nextRow < board.length
    				&& nextColumn >= 0 && nextColumn < board[0].length
    				&& !visited[nextRow][nextColumn]){
    			visited[nextRow][nextColumn] = true;
    			currentPrefix.append(board[nextRow][nextColumn]);
    			dfs(board, nextRow, nextColumn, currentPrefix, visited, prefixSet, result);
    			currentPrefix.deleteCharAt(currentPrefix.length() - 1);
    			visited[nextRow][nextColumn] = false;
    		}
    	}
    }
}
