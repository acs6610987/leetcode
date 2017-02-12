package n269_alien_dictionary;

public class Test {
	public static void main(String[] args){
		String[] words = new String[]{
				"wrt", "wrf", "er", "ett", "rftt"
		};
		System.out.println(new Solution().alienOrder(words));
		
		words = new String[]{
				"wrtkj","wrt"
		};
		System.out.println(new Solution().alienOrder(words));
		
		words = new String[]{
				"ac","ab","b"
		};
		System.out.println(new Solution().alienOrder(words));
		
		words = new String[]{
				"wnlb"
		};
		System.out.println(new Solution().alienOrder(words));
		
	}
}
