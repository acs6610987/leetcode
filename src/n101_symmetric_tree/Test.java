package n101_symmetric_tree;

public class Test {
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1), node2 = new TreeNode(2),
				node3 = new TreeNode(2), node4 = new TreeNode(3),
				node5 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.right = node5;
		System.out.println(new Solution().isSymmetric(node1));
	}
}
