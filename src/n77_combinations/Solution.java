package n77_combinations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        results.add(new ArrayList<>());
        for(int i = 1; i <= k; i++){
        	int size = results.size();
        	for(int j = 0; j < size; j++){
        		List<Integer> solution = results.poll();
        		int next = solution.size() == 0 ? 1 : solution.get(solution.size() - 1) + 1;
        		for(; next <= n - (k - solution.size()) + 1; next++){
        			List<Integer> newSolution = new ArrayList<>(solution);
        			newSolution.add(next);
        			results.add(newSolution);
        		}
        	}
        }
        return results;
    }
}
