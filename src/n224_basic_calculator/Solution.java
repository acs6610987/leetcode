package n224_basic_calculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;
        while(i < s.length()){
        	char token = s.charAt(i++);
        	if(token == ' ') continue;
        	else if(token == '(' || token == '+' || token == '-') operators.push(token);
        	else{
        		int operand =  0;
        		if(token == ')') {
        			operators.pop();
        			operand = nums.pop();
        		}
	        	else if(token >= '0' && token <= '9'){
	        		StringBuilder operandStr = new StringBuilder();
	        		operandStr.append(token);
	        		while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9')
	        			operandStr.append(s.charAt(i++));
	        		operand = Integer.valueOf(operandStr.toString());
	        	}
        		if(operators.isEmpty() || operators.peek() == '(')
        			nums.push(operand);
        		else if(operators.peek() == '+'){
        			nums.push(nums.pop() + operand);
        			operators.pop();
        		}
        		else if(operators.peek() == '-'){ 
        			nums.push(nums.pop() - operand);
        			operators.pop();
        		}
        	}
        }
        return nums.peek();
    }
}