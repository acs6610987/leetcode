package n124_binary_tree_maximum_path_sum;

public class Test {
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(-3), node2 = new TreeNode(2), node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		System.out.println(new Solution().maxPathSum(node1));
	}
}
