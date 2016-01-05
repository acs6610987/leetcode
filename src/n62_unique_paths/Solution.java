package n62_unique_paths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
	HashMap<Integer, List<Integer>> factorsMap = new HashMap<>();
	{
		for(int i = 1; i <= 200; i++){
			factorsMap.put(i, factorize(i));
		}
	}
    public int uniquePaths(int m, int n) {
    	m--; n--;
    	if(m > n){
        	int tmp = m;
        	m = n;
        	n = tmp;
        }
    	HashMap<Integer, Integer> factorNums = new HashMap<>();
    	int i = m;
    	while(i > 0){
    		List<Integer> numeratorFactors = factorsMap.get(i+n);
    		List<Integer> denominatorFactors = factorsMap.get(i);
    		for(int j = 0; j < numeratorFactors.size(); j++){
    			int f = numeratorFactors.get(j);
    			if(!factorNums.containsKey(f))
    				factorNums.put(f, 0);
    			factorNums.put(f, factorNums.get(f) + 1);
    		}
    		for(int j = 0; j < denominatorFactors.size(); j++){
    			int f = denominatorFactors.get(j);
    			if(!factorNums.containsKey(f))
    				factorNums.put(f, 0);
    			factorNums.put(f, factorNums.get(f) - 1);
    		}
    		i--;
    	}
    	int total = 1;
    	for(Entry<Integer, Integer> e : factorNums.entrySet()){
    		for(int j = 0; j < e.getValue(); j++)
    			total *= e.getKey();
    	}
    	return total;
    }
    
    public List<Integer> factorize(int n){
    	List<Integer> factors = new ArrayList<>();
    	for(int i = 2; i <= Math.sqrt(n); i++){
    		while(n % i == 0){
    			factors.add(i);
    			n /= i;
    		}
    	}
    	factors.add(n);
    	return factors;
    }
}