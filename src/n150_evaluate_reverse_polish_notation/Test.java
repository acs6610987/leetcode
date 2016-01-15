package n150_evaluate_reverse_polish_notation;

public class Test {
	public static void main(String[] args){
		String[] tokens = new String[]{"2", "1", "+", "3", "*"};
		System.out.println(new Solution().evalRPN(tokens));
		tokens = new String[]{"4", "13", "5", "/", "+"};
		System.out.println(new Solution().evalRPN(tokens));
	}
}
