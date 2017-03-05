package n4_median_of_two_sorted_arrays;

public class Test {
	public static void main(String[] args){
		int[] nums1 = new int[]{1, 3},
				nums2 = new int[]{2};
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
		
		nums1 = new int[]{1, 2};
		nums2 = new int[]{3, 4};
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
		
		nums1 = new int[]{};
		nums2 = new int[]{1};
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
		
		nums1 = new int[]{3};
		nums2 = new int[]{1, 2};
		System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
	}
}
