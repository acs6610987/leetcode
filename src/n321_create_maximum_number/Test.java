package n321_create_maximum_number;

public class Test {
	public static void main(String[] args){
		int[] nums1 = new int[]{3, 4, 6, 5};
		int[] nums2 = new int[]{9, 1, 2, 5, 8, 3};
		int k = 5;
		int[] result = new Solution().maxNumber(nums1, nums2, k);
//		for(int i = 0; i < result.length; i++){
//			System.out.print(result[i]);
//		}
//		System.out.println();
//		
//		nums1 = new int[]{6, 7};
//		nums2 = new int[]{6, 0, 4};
//		k = 5;
//		result = new Solution().maxNumber(nums1, nums2, k);
//		for(int i = 0; i < result.length; i++){
//			System.out.print(result[i]);
//		}
//		System.out.println();
//		
//		nums1 = new int[]{3, 9};
//		nums2 = new int[]{8, 9};
//		k = 3;
//		result = new Solution().maxNumber(nums1, nums2, k);
//		for(int i = 0; i < result.length; i++){
//			System.out.print(result[i]);
//		}
//		System.out.println();
//		
//		nums1 = new int[]{2, 5, 6, 4, 4, 0};
//		nums2 = new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2};
//		k = 15;
//		result = new Solution().maxNumber(nums1, nums2, k);
//		for(int i = 0; i < result.length; i++){
//			System.out.print(result[i]);
//		}
//		//738256440657620
//		System.out.println();
		
		nums1 = new int[]{5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3};
		nums2 = new int[]{7,6,7,1,0,1,0,5,6,0,5,0};
		k = 31;
		result = new Solution().maxNumber(nums1, nums2, k);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i]);
		}
	}
}
