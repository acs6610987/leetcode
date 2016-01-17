package n275_H_index_II;

public class Test {
	public static void main(String[] args){
		int[] citations = new int[]{0, 1, 3, 5, 6};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{3, 3, 5, 8, 25};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{3, 4, 5, 8, 10};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{8};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{};
		System.out.println(new Solution().hIndex(citations));
	}
}
