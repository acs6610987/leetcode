package n305_number_of_islands_II;

import java.util.List;


public class Test {
	public static void main(String[] args){
		int m = 3, n = 3;
		int[][] positions = new int[][]{
				{0, 0}, {0, 1}, {1, 2}, {2, 1}
		};
		
		List<Integer> result = new Solution().numIslands2(m, n, positions);
		for(int i = 0; i < result.size(); i++)
			System.out.print(result.get(i));
	}
}
