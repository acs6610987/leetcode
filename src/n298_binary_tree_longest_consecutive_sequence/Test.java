package n298_binary_tree_longest_consecutive_sequence;

public class Test {
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[]{
				new TreeNode(1),
				new TreeNode(3),
				new TreeNode(2),
				new TreeNode(4),
				new TreeNode(5)
		};
		nodes[0].right = nodes[1];
		nodes[1].left = nodes[2];
		nodes[1].right = nodes[3];
		nodes[3].right = nodes[4];
		
		TreeNode root = nodes[0];
		System.out.println(new Solution().longestConsecutive(root));
		
		nodes = new TreeNode[]{
				new TreeNode(2),
				new TreeNode(3),
				new TreeNode(2),
				new TreeNode(1)
		};
		nodes[0].right = nodes[1];
		nodes[1].left = nodes[2];
		nodes[2].left = nodes[3];
		root = nodes[0];
		System.out.println(new Solution().longestConsecutive(root));
	}
}
