package n224_basic_calculator;

public class Test {
	public static void main(String[] args){
		String s = "1 + 1";
		System.out.println(new Solution().calculate(s));
		s = " 2-1 + 2 ";
		System.out.println(new Solution().calculate(s));
		s = "(1+(4+5+2)-3)+(6+8)";
		System.out.println(new Solution().calculate(s));
	}
}
