package n162_find_peak_element;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1, 2, 3, 1};
		System.out.println(new Solution().findPeakElement(nums));
		nums = new int[]{1};
		System.out.println(new Solution().findPeakElement(nums));
		nums = new int[]{1, 2};
		System.out.println(new Solution().findPeakElement(nums));
	}
}
