package n39_combination_sum;

import java.util.List;

public class Test {
	public static void main(String[] args){
		int[] candidates = new int[]{2, 3, 6, 7};
		List<List<Integer>> list = new Solution().combinationSum(candidates, 16);
		for(int i = 0; i < list.size(); i++){
			for(int j =0; j < list.get(i).size(); j++){
				System.out.print(list.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
}
