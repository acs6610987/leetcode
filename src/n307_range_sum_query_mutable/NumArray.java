package n307_range_sum_query_mutable;


public class NumArray {
	private Node root;
	private Node[] leaves;
    public NumArray(int[] nums) {
    	if(nums.length == 0) return;
    	leaves = new Node[nums.length];
        root = buildTree(nums, 0, nums.length - 1);
        root.parent = null;
    }
    
    private Node buildTree(int[] nums, int start, int end){
    	Node parent = new Node(start, end);
    	if(start == end){
    		parent.left = parent.right = null;
    		parent.sum = nums[start];
    		leaves[start] = parent;
    	}
    	else{
	    	parent.left = buildTree(nums, start, (start + end) / 2);
	    	parent.right = buildTree(nums, (start + end) / 2 + 1, end);
	    	parent.sum = parent.left.sum + parent.right.sum;
	    	parent.left.parent = parent.right.parent = parent;
    	}
    	return parent;
    }

    void update(int i, int val) {
    	int diff = val - leaves[i].sum;
        Node node = leaves[i];
        while(node != null){
        	node.sum += diff;
        	node = node.parent;
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(Node node, int i, int j){
    	if(node.start == i && node.end == j) return node.sum;
    	int leftEnd = (node.start + node.end) / 2;
    	if(leftEnd < i)
    		return sumRange(node.right, i, j);
    	if(j < leftEnd + 1)
    		return sumRange(node.left, i, j);
    	return sumRange(node.left, i, leftEnd) + sumRange(node.right, leftEnd + 1, j);
    }
    
    class Node{
    	private int start, end;
    	private int sum;
    	private Node left, right;
    	private Node parent;
    	Node(int start, int end){
    		this.start = start;
    		this.end = end;
    	}
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);