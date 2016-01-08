package n110_balanced_binary_tree;

public class Test {
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2),
				node3 = new TreeNode(3), node4 = new TreeNode(4);
		node1.left = null;
		node1.right = node3;
		node3.left = node4;
		node4.right = node2;
		System.out.println(new Solution().isBalanced(node1));
	}
}
