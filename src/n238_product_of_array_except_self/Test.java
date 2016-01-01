package n238_product_of_array_except_self;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1,2,3,4};
		int[] output = new Solution().productExceptSelf(nums);
		for(int i = 0; i < output.length; i++)
			System.out.print(output[i] + ", ");
	}
}
