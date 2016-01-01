package n100_same_tree;

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
		
		TreeNode node11 = new TreeNode(1), node12 = new TreeNode(2),
				node13 = new TreeNode(3), node14 = new TreeNode(4),
				node16 = new TreeNode(6), node17 = new TreeNode(7),
				node19 = new TreeNode(9);
		node14.left = node12;
		node14.right = node17;
		node12.left = node11;
		node12.right = node13;
		node17.left = node16;
		node17.right = node19;
		System.out.println(new Solution().isSameTree(node4, node14));
		System.out.println(new Solution().isSameTree(node3, node14));
		System.out.println(new Solution().isSameTree(node3, node13));
		System.out.println(new Solution().isSameTree(null, node14));
		System.out.println(new Solution().isSameTree(null, null));
	}
}
