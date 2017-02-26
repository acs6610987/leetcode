package n163_missing_ranges;

import java.util.List;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{0, 1, 3, 50, 75};
		int lower = 0, upper = 99;
		List<String> ranges = new Solution().findMissingRanges(nums, lower, upper);
		for(int i = 0; i < ranges.size(); i++)
			System.out.println(ranges.get(i));
		
		nums = new int[]{1, 1, 1};
		lower = 1;
		upper = 1;
		ranges = new Solution().findMissingRanges(nums, lower, upper);
		for(int i = 0; i < ranges.size(); i++)
			System.out.println(ranges.get(i));
		
		nums = new int[]{-2147483648, 2147483647};
		lower = -2147483648;
		upper = 2147483647;
		ranges = new Solution().findMissingRanges(nums, lower, upper);
		for(int i = 0; i < ranges.size(); i++)
			System.out.println(ranges.get(i));
		
		nums = new int[]{2147483647};
		lower = -2147483648;
		upper = 2147483647;
		ranges = new Solution().findMissingRanges(nums, lower, upper);
		for(int i = 0; i < ranges.size(); i++)
			System.out.println(ranges.get(i));
	}
}
