package lca_binary_tree_236;
//depth-first search

public class Solution {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root == p || root == q || root == null)
			return root;
		TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
		TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);
		if(null == leftLCA) return rightLCA;
		if(null == rightLCA) return leftLCA;
		return root; 
    }
}
