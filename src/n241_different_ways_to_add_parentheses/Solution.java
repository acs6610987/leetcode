package n241_different_ways_to_add_parentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Object> tokens = tokenize(input);
        Stack<Object> compStack = new Stack<>();
        List<Integer> results = new LinkedList<>();
        if(tokens.size() == 0) return results;
        compStack.push(tokens.get(0));
        backTrackCompute(tokens, 1, compStack, results);
        return results;
    }
    
    private void backTrackCompute(List<Object> tokens, int index, Stack<Object> compStack, List<Integer> results){
    	if(index >= tokens.size()){
    		results.add((Integer)compStack.pop());
    		return;
    	}
    	char operator = (Character) tokens.get(index);
    	int operand1, operand2 = (Integer) tokens.get(index + 1);
    	compStack.push(operator);
    	compStack.push(operand2);
    	if(index + 2 < tokens.size()){
    		while(compStack.size() > 2){
    			Stack<Object> newStack = new Stack<>();
    			newStack.addAll(compStack);
    			backTrackCompute(tokens, index+2, newStack, results);
    			operand2 = (Integer) compStack.pop();
    			operator = (Character) compStack.pop();
    			operand1 = (Integer) compStack.pop();
    			compStack.push(compute(operand1, operand2, operator));
    		}
    	}
    	else{
    		operand2 = (Integer) compStack.pop();
    		while(compStack.size() > 1){
    			operator = (Character) compStack.pop();
    			operand1 = (Integer) compStack.pop();
    			operand2 = compute(operand1, operand2, operator);
    		}
    		compStack.push(operand2);
    	}
    	backTrackCompute(tokens, index+2, compStack, results);
    }
    
    private List<Object> tokenize(String input){
    	List<Object> tokens = new ArrayList<>();
    	int i = 0;
    	while(i < input.length()){
    		char t = input.charAt(i);
    		switch(t){
    		case '+': 
    		case '-':
    		case '*':
    			tokens.add(t);
    			i++;
    			break;
    		default:
    			int end = i+1;
    			while(end < input.length() && input.charAt(end) >= '0' && input.charAt(end) <= '9')
    				end++;
    			tokens.add(Integer.valueOf(input.substring(i, end)));
    			i = end;
    		}
    	}
    	return tokens;
    }
    
    private int compute(int operand1, int operand2, char operator){
    	switch(operator){
    	case '+':
    		return operand1 + operand2;
    	case '-':
    		return operand1 - operand2;
    	case '*':
    		return operand1 * operand2;
    	}
    	return 0;
    }
}
