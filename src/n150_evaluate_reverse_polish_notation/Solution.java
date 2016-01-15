package n150_evaluate_reverse_polish_notation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> rpnStack = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
        	char letter = tokens[i].charAt(0);
        	switch(letter){
        	case '+':
        		rpnStack.push(rpnStack.pop() + rpnStack.pop());
        		break;
        	case '-':
        		if(tokens[i].length() == 1)	
        			rpnStack.push(-(rpnStack.pop() - rpnStack.pop()));
        		else
        			rpnStack.push(Integer.valueOf(tokens[i]));
        		break;
        	case '*':
        		rpnStack.push(rpnStack.pop() * rpnStack.pop());
        		break;
        	case '/':
        		int denominator = rpnStack.pop();
        		rpnStack.push(rpnStack.pop() / denominator);
        		break;
        	default:
        		rpnStack.push(Integer.valueOf(tokens[i]));
        	}
        }
        return rpnStack.peek();
    }
}