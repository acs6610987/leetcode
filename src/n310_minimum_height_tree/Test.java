package n310_minimum_height_tree;

public class Test {
	public static void main(String[] args){
		Solution sol = new Solution();
		int[][] edges1 = new int[][]{
				{1, 0},
				{1, 2},
				{1, 3}
		};
		int[][] edges2 = new int[][]{
				{0, 3},
				{1, 3},
				{2, 3},
				{4, 3},
				{5, 4}
		};
		System.out.println(sol.findMinHeightTrees(4, edges1));
		System.out.println(sol.findMinHeightTrees(6, edges2));
	}
}
