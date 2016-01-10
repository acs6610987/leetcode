package n301_remove_invalid_parentheses;

import java.util.List;

public class Test {
	public static void main(String[] args){
		String s = "()())()";
//		String s = "(a)())()";
//		String s = ")(";
		List<String> results = new Solution().removeInvalidParentheses(s);
		for(int i = 0; i < results.size(); i++)
			System.out.println(results.get(i));
	}
}
