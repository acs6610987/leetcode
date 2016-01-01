package n226_invert_binary_tree;

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
		new Solution().invertTree(node4);
		System.out.println(node4.val);
		System.out.println(node4.left.val + ", " + node4.right.val);
		System.out.println(node4.left.left.val + ", " + node4.left.right.val
				+ ", " + node4.right.left.val + ", " + node4.right.right.val);
	}
}
