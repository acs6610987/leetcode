package n45_jump_game_II;

public class Solution {
    public int jump(int[] nums) {
        int[] minJumps = new int[nums.length];
        int i = 0, nextJumpIndex = 1;
        while(i < nums.length){
        	for(; nextJumpIndex <= i + nums[i] && nextJumpIndex < nums.length; nextJumpIndex++)
        		minJumps[nextJumpIndex] = minJumps[i] + 1;
        	i++;
        }
        return minJumps[nums.length - 1];
    }
}