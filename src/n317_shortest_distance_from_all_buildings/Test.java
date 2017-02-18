package n317_shortest_distance_from_all_buildings;

public class Test {
	public static void main(String[] args){
		int[][] grid = new int[][]{
				{1, 0, 2, 0, 1},
				{0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0}
		};
		System.out.println(new Solution().shortestDistance(grid));
	}
}
