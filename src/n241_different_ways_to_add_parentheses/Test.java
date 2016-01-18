package n241_different_ways_to_add_parentheses;

import java.util.List;

public class Test {
	public static void main(String[] args){
		String[] cases = new String[]{
				"",
				"2-1-1",
				"2*3-4*5"
		};
		for(int i = 0; i < cases.length; i++){
			List<Integer> list = new Solution().diffWaysToCompute(cases[i]);
			for(int j = 0; j < list.size(); j++)
				System.out.print(list.get(j) + ", ");
			System.out.println();
		}
	}
}
