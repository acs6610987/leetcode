package n65_valid_number;

public class Test {
	public static void main(String[] args){
		String[] strs = new String[]{
				"0",
				" 0.1 ",
				"abc",
				"1 a",
				"2e10",
				"1.",
				".1",
				"1e",
				"e1",
				".",
				"e",
				"-1",
				"-1e-2",
				"-1.-4",
				"",
				".+8",
				"46.e3",
				".e3"
		};
		for(int i = 0; i < strs.length; i++){
			System.out.println(strs[i] + ": " + new Solution().isNumber(strs[i]));
		}
		System.out.println(-.1e3);
	}
}
