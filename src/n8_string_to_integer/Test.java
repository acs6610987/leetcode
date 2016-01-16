package n8_string_to_integer;

public class Test {
	public static void main(String[] args){
		String[] strs = new String[]{
				"0",
				"+54",
				"-43",
				" 235",
				"d32",
				"434e",
				"-2147483648",
				"2147483647",
				"9999999999",
				"-9999999999",
				"-1",
				"-10"
				
		};
		for(int i = 0; i < strs.length; i++){
			System.out.println(strs[i] + ": " + new Solution().myAtoi(strs[i]));
		}
	}
}
