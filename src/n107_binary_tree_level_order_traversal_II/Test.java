package n107_binary_tree_level_order_traversal_II;

import java.util.List;

public class Test {
	public static void main(String[] args){
		TreeNode node3 = new TreeNode(3), node9= new TreeNode(9),
				node20 = new TreeNode(20), node15 = new TreeNode(15),
				node7 = new TreeNode(7);
		node3.left = node9;
		node3.right = node20;
		node20.left = node15;
		node20.right = node7;
		List<List<Integer>> list = new Solution().levelOrderBottom(node3);
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.get(i).size(); j++)
				System.out.print(list.get(i).get(j) + ", ");
			System.out.println();
		}
	}
}
