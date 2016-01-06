package n46_permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
	public static void main(String[] args){
		int[] nums = new int[]{1, 2, 3};
		List<List<Integer>> results = new Solution().permute(nums);
		for(int i = 0; i < results.size(); i++){
			for(int j = 0; j < results.get(i).size(); j++)
				System.out.print(results.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}
