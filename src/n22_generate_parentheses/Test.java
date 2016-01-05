package n22_generate_parentheses;

import java.util.List;

public class Test {
	public static void main(String[] args){
		List<String> results = new Solution().generateParenthesis(3);
		for(int i = 0; i < results.size(); i++)
			System.out.println(results.get(i));
	}
}
