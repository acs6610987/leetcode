package n77_combinations;

import java.util.List;

public class Test {
	public static void main(String[] args){
		List<List<Integer>> results = new Solution().combine(4,  5);
		for(int i = 0; i < results.size(); i++){
			for(int j = 0; j < results.get(i).size(); j++)
				System.out.print(results.get(i).get(j));
			System.out.println();
		}
	}
}
