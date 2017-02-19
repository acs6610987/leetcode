package n358_rearranging_string_k_distance_apart;

public class Test {
	public static void main(String[] args){
		String s = "aaadbbcc";
		int k = 2;
		System.out.println(new Solution().rearrangeString(s, k));
		s = "a";
		k = 2;
		System.out.println(new Solution().rearrangeString(s, k));
	}
}
