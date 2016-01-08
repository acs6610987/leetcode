package n216_combination_sum_III;

import java.util.List;

public class Test {
	public static void main(String[] args){
		List<List<Integer>> list = new Solution().combinationSum3(2, 18);
		for(int i = 0; i < list.size(); i++){
			for(int j =0; j < list.get(0).size(); j++){
				System.out.print(list.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
}
