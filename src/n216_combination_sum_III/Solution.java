package n216_combination_sum_III;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        LinkedList<List<Integer>> combinations = new LinkedList<>();
        List<Integer> solution = new ArrayList<Integer>();
        solution.add(n);
        combinations.add(solution);
        for(int i = 1; i < k; i++){
        	int currentSize = combinations.size();
        	for(int j = 0; j < currentSize; j++){
        		solution = combinations.poll();
        		int solutionLen = solution.size();
        		int next = solutionLen > 1? solution.get(solutionLen - 2) + 1 : 1;
        		int remainder = solution.get(solutionLen - 1);
        		solution.add(0);
        		for(; next <= (remainder - 1) / 2 && next <= 9; next++){
        			solution.set(solutionLen - 1, next);
        			solution.set(solutionLen, remainder - next);
        			List<Integer> newSolution = new ArrayList<Integer>(solution);
        			combinations.add(newSolution);
        		}
        	}
        }
        for(int i = combinations.size() - 1; i >= 0; i--){
        	solution = combinations.get(i);
        	if(solution.get(solution.size() - 1) > 9)
        		combinations.remove(i);
        }
        return combinations;
    }
}