package n55_jump_game;

public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] reachable = new boolean[nums.length];
        reachable[0] = true;
        int i = 0, j, furthest = 0;
        while(i < nums.length){
        	if(reachable[i]){
	        	for(j = furthest + 1; j <= i + nums[i] && j < reachable.length; j++){
	        		reachable[j] = true;
	        	}
	        	furthest = j - 1;
	        	if(furthest == reachable.length - 1)
	        		return true;
        	}
        	i++;
        }
        return false;
    }
}