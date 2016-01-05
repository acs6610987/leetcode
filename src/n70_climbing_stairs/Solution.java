package n70_climbing_stairs;

public class Solution {
	int[] ways;
    public int climbStairs(int n) {
        ways = new int[n+1];
        return recursiveClimb(n);
    }
    
    private int recursiveClimb(int n){
    	if(n == 1) return 1;
    	if(n == 2) return 2;
    	if(ways[n] != 0) return ways[n];
    	ways[n] = recursiveClimb(n-1) + recursiveClimb(n-2);
    	return ways[n];
    }
}
