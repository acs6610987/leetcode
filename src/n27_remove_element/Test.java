package n27_remove_element;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{};
		int len = new Solution().removeElement(nums, 1);
		for(int i = 0; i < len; i++){
			System.out.print(nums[i] + ", ");
		}
	}
}
