package n144_binary_tree_preorder_traversal;

import java.util.List;


public class Test {
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2),
				node3 = new TreeNode(3), node4 = new TreeNode(4),
				node6 = new TreeNode(6), node7 = new TreeNode(7),
				node9 = new TreeNode(9);
		node4.left = node2;
		node4.right = node7;
		node2.left = node1;
		node2.right = node3;
		node7.left = node6;
		node7.right = node9;
		List<Integer> results = new Solution().preorderTraversal(node4);
		for(int i = 0; i < results.size(); i++)
			System.out.print(results.get(i) + ", ");
	}
}
