package n117_populating_next_right_pointers_in_each_node_II;

public class Test {
	public static void main(String[] args){
		TreeLinkNode node1 = new TreeLinkNode(1), node2= new TreeLinkNode(2),
				node3 = new TreeLinkNode(3), node4 = new TreeLinkNode(4),
				node5 = new TreeLinkNode(5), node7 = new TreeLinkNode(7);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.right = node7;
		new Solution().connect(node1);
		TreeLinkNode[] heads = new TreeLinkNode[]{node1, node2, node4};
		for(int i = 0; i < heads.length; i++){
			while(heads[i] != null){
				System.out.print(heads[i].val + ", ");
				heads[i] = heads[i].next;
			}
			System.out.println();
		}
		
	}
}
