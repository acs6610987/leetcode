package n54_spiral_matrix;

import java.util.List;

public class Test {
	public static void main(String[] args){
		int[][] matrix = new int[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		List<Integer> list = new Solution().spiralOrder(matrix);
		for(int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + ",");
	}
}
