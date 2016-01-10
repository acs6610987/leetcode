package n99_recover_binary_search_tree;

public class Test {
	public static void main(String[] args){
		TreeNode[] nodes = new TreeNode[9];
		for(int i = 0; i < 9; i++)
			nodes[i] = new TreeNode(i);
		nodes[5].left = nodes[2];
		nodes[5].right = nodes[7];
		nodes[2].left = nodes[0];
		nodes[2].right = nodes[4];
		nodes[0].right = nodes[1];
		nodes[4].left = nodes[3];
		nodes[7].left = nodes[6];
		nodes[7].right = nodes[8];
		
		nodes[2].val = 4;
		nodes[4].val = 2;
		for(int i = 0; i < 9; i++)
			System.out.print(nodes[i].val + ", ");
		System.out.println();
		
		new Solution().recoverTree(nodes[5]);
		for(int i = 0; i < 9; i++)
			System.out.print(nodes[i].val + ", ");
		System.out.println();
		
		nodes[0].val = 1;
		nodes[1].val = 0;
		for(int i = 0; i < 9; i++)
			System.out.print(nodes[i].val + ", ");
		System.out.println();
		
		new Solution().recoverTree(nodes[5]);
		for(int i = 0; i < 9; i++)
			System.out.print(nodes[i].val + ", ");
		System.out.println();
	}
}
