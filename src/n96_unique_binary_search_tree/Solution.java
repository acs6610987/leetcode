package n96_unique_binary_search_tree;

public class Solution {
	int[] uniques;
    public int numTrees(int n) {
        uniques = new int[n+1];
        uniques[0] = 1;
        return recursiveNumTrees(n);
    }
    
    public int recursiveNumTrees(int n){
    	if(uniques[n] != 0) return uniques[n];
    	int total = 0;
    	for(int i = 0; i <= n-1; i++)
    		total += recursiveNumTrees(i) * recursiveNumTrees(n-i-1);
    	uniques[n] = total;
    	return total;
    }
}