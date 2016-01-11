package n289_game_of_life;

public class Solution {
    public void gameOfLife(int[][] board) {
    	for(int i = 0; i < board.length; i++)
    		for(int j = 0; j < board[0].length; j++)
    			board[i][j] = board[i][j] == 0 ? 0 : 3;
    	for(int i = 0; i < board.length; i++)
    		for(int j = 0; j < board[0].length; j++){
    			int liveNeighbors = numOfLiveNeighbors(board, i, j);
    			if(board[i][j] == 3){
    				if(liveNeighbors < 2 || liveNeighbors > 3)
    					board[i][j] -= 1;
    			}
    			else if(liveNeighbors == 3)
    				board[i][j] += 1;
    		}
    	for(int i = 0; i < board.length; i++)
    		for(int j = 0; j < board[0].length; j++)
    			board[i][j] = board[i][j] % 2;
    }
    
    private int numOfLiveNeighbors(int[][] board, int i, int j){
    	int num = 0;
    	if(i-1 >= 0){
    		num += board[i-1][j] >> 1;
    		if(j-1 >= 0)
    			num += board[i-1][j-1] >> 1;
    		if(j+1 <= board[i].length - 1)
    			num += board[i-1][j+1] >> 1;
    	}
    	if(j-1 >= 0)
    		num += board[i][j-1] >> 1;
    	if(j+1 <= board[i].length - 1)
    		num += board[i][j+1] >> 1;
    	if(i+1 <= board.length - 1){
    		num += board[i+1][j] >> 1;
    		if(j-1 >= 0)
    			num += board[i+1][j-1] >> 1;
    		if(j+1 <= board[i].length - 1)
    			num += board[i+1][j+1] >> 1;
    	}
    	return num;
    }
}