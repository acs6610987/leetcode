package n301_remove_invalid_parentheses;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private List<String> results;
    public List<String> removeInvalidParentheses(String s) {
        results = new LinkedList<>();
        buildString(s, "", 0, 0);
        return results;
    }
    
    public void buildString(String s, String cur, int index, int left){
    	if(results.size() > 0 && (cur.length() + s.length() - index) < results.get(0).length())
    		return;
    	if(index >= s.length()){
    		if(left == 0) results.add(cur);
    		return;
    	}
    	char letter = s.charAt(index);
    	int len = 0;
    	while(index+len < s.length() && s.charAt(index+len) == letter) {
    		len++;
    	}
    	if(letter == '('){
    		for(int i = len; i >= 0; i--)
    			buildString(s, cur + s.substring(index, index+i), index+len, left+i);
    	}
    	else if(letter == ')'){
    		int rightUpperBound = min(left, len);
    		for(int i = rightUpperBound; i >= 0; i--)
    			buildString(s, cur + s.substring(index, index+i), index+len, left-i);
    	}
    	else
    		buildString(s, cur+s.substring(index, index+len), index+len, left);
    }
    
    private int min(int a, int b){
    	return a < b ? a : b;
    }
}