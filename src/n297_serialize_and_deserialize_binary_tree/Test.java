package n297_serialize_and_deserialize_binary_tree;

public class Test {
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1),
				node2 = new TreeNode(2),
				node3 = new TreeNode(3),
				node4 = new TreeNode(4),
				node5 = new TreeNode(5);
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		String code = new Codec().serialize(node1);
		System.out.println(code);
		System.out.println(new String("a") == "a");
		TreeNode root = new Codec().deserialize(code);
		System.out.println(root.val);
	}
}
