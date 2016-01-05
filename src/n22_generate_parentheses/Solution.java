package n22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> results = new ArrayList<>();
    	if(n <= 0) return results;
        genPartialParenthesis("", n, n, results);
        return results;
    }
    
    private void genPartialParenthesis(String partialStr, int left, int right, List<String> results){
    	if(left == 0){
    		while(right-- > 0) partialStr += ")";
    		results.add(partialStr);
    		return;
    	}
    	genPartialParenthesis(partialStr + "(", left - 1, right, results);
    	if(left < right)
    		genPartialParenthesis(partialStr + ")", left, right - 1, results);
    }
}
