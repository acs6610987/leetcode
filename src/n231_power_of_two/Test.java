package n231_power_of_two;

public class Test {
	public static void main(String[] args){
		System.out.println(new Solution().isPowerOfTwo(1));
		System.out.println(new Solution().isPowerOfTwo(1<<31));
		System.out.println(new Solution().isPowerOfTwo(1<<30));
		System.out.println(new Solution().isPowerOfTwo(0));
	}
}
