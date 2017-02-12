package n135_candy;

public class Test {
	public static void main(String[] args){
		int[] ratings = new int[]{2, 1};
		System.out.println(new Solution().candy(ratings));
		
		ratings = new int[]{1, 2, 2};
		System.out.println(new Solution().candy(ratings));
		
		ratings = new int[]{4,2,3,4,1};
		System.out.println(new Solution().candy(ratings));
		
		ratings = new int[]{1,3,4,3,2,1};
		System.out.println(new Solution().candy(ratings));q
	}
}
