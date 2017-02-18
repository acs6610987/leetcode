package n305_number_of_islands_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
    	LandNode[][] nodes = new LandNode[m + 2][n + 2];
    	List<Integer> islands = new ArrayList<Integer>(positions.length);
    	for(int i = 0; i < positions.length; i++){
    		int mRow = positions[i][0] + 1, mColumn = positions[i][1] + 1;
    		if(nodes[mRow][mColumn] != null) continue;
    		nodes[mRow][mColumn] = new LandNode(mRow, mColumn);
    		if(i == 0)
    			islands.add(1);
    		else
    			islands.add(islands.get(i - 1) + 1);
    		if(nodes[mRow - 1][mColumn] != null && union(nodes[mRow][mColumn], nodes[mRow - 1][mColumn]))
    			islands.set(i, islands.get(i) - 1);
    		if(nodes[mRow + 1][mColumn] != null && union(nodes[mRow][mColumn], nodes[mRow + 1][mColumn]))
    			islands.set(i, islands.get(i) - 1);
    		if(nodes[mRow][mColumn - 1] != null && union(nodes[mRow][mColumn], nodes[mRow][mColumn - 1]))
    			islands.set(i, islands.get(i) - 1);
    		if(nodes[mRow][mColumn + 1] != null && union(nodes[mRow][mColumn], nodes[mRow][mColumn + 1]))
    			islands.set(i, islands.get(i) - 1);
    	}
    	return islands;
    }
    
    private boolean union(LandNode n1, LandNode n2){
    	LandNode p1 = find(n1), p2 = find(n2);
    	if(p1 == p2) return false;
    	if(p1.size > p2.size){
    		p2.parent = p1;
    		p1.size += p2.size;
    	}
    	else{
    		p1.parent = p2;
    		p2.size += p1.size;
    	}
    	return true;
    }
    
    private LandNode find(LandNode n){
    	if(n.parent != null){
    		n.parent = find(n.parent);
    		return n.parent;
    	}
    	else
    		return n;
    }
    
    class LandNode{
    	int row, column;
    	LandNode parent;
    	int size;
    	public LandNode(int r, int c){
    		row = r;
    		column = c;
    		parent = null;
    		size = 1;
    	}
    }
}