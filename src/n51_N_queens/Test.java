package n51_N_queens;

import java.util.List;

public class Test {
	public static void main(String[] args){
		List<List<String>> sols = new Solution().solveNQueens(4);
		for(int i = 0; i < sols.size(); i++){
			for(int j = 0; j < sols.get(0).size(); j++)
				System.out.println(sols.get(i).get(j));
			System.out.println("\n");
		}
	}
}
