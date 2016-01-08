package n39_combination_sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        LinkedList<List<Integer>> combinations = new LinkedList<>();
        LinkedList<Integer> solution = new LinkedList<>();
        solution.add(target);
        combinations.add(solution);
        for(int i = 0; i < candidates.length; i++){
        	int currentSize = combinations.size();
        	for(int j = 0; j < currentSize; j++){
        		solution = (LinkedList)combinations.poll();
        		int remainder = solution.removeLast();
        		if(i == candidates.length - 1 && remainder % candidates[i] != 0) continue;
        		for(int k = 0; k <= remainder / candidates[i]; k++){
        			if(i < candidates.length - 1){
	        			LinkedList<Integer> newSolution = new LinkedList<>(solution);
	        			newSolution.add(remainder - candidates[i]*k);
	        			combinations.add(newSolution);
        			}
        			else if(k == remainder / candidates[i]){
        				LinkedList<Integer> newSolution = new LinkedList<>(solution);
        				combinations.add(newSolution);
        			}
        			solution.add(candidates[i]);
        		}
        	}
        }
        return combinations;
    }
}