package n129_sum_root_to_leaf_numbers;

public class Test {
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[]{
				new TreeNode(1),
				new TreeNode(2),
				new TreeNode(3)
		};
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		System.out.println(new Solution().sumNumbers(nodes[0]));
	}
}
