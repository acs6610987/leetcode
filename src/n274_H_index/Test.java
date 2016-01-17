package n274_H_index;

public class Test {
	public static void main(String[] args){
		int[] citations = new int[]{3, 0, 6, 1, 5};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{8, 5, 3, 25, 3};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{8, 5, 10, 4, 3};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{8};
		System.out.println(new Solution().hIndex(citations));
		citations = new int[]{};
		System.out.println(new Solution().hIndex(citations));
	}
}
