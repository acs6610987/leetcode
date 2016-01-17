package n199_binary_tree_right_side_view;

import java.util.List;

public class Test {
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[]{
				new TreeNode(1),
				new TreeNode(2),
				new TreeNode(3),
				new TreeNode(4)
		};
		nodes[0].left = nodes[1];
		nodes[0].right = nodes[2];
		nodes[1].left = nodes[3];
		List<Integer> list = new Solution().rightSideView(nodes[0]);
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i) + ", ");
	}
}
