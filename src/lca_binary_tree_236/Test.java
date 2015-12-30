package lca_binary_tree_236;

public class Test {
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[9];
		for(int i = 0; i < 9; i++)
			nodes[i] = new TreeNode(i);
		nodes[3].left = nodes[5];
		nodes[3].right = nodes[1];
		nodes[5].left = nodes[6];
		nodes[5].right = nodes[2];
		nodes[1].left = nodes[0];
		nodes[1].right = nodes[8];
		nodes[2].left = nodes[7];
		nodes[2].right = nodes[4];
		TreeNode lca = new Solution().lowestCommonAncestor(nodes[3], nodes[5], nodes[1]);
		System.out.println(lca.val);
		lca = new Solution().lowestCommonAncestor(nodes[3], nodes[5], nodes[4]);
		System.out.println(lca.val);
		lca = new Solution().lowestCommonAncestor(nodes[3], nodes[7], nodes[6]);
		System.out.println(lca.val);
	}
}
