package n308_range_sum_query_2d_mutable;

public class NumMatrix_SegmentTree_TimeOut {

	private SquareNode root;
	private SquareNode[][] leaves;
	
    public NumMatrix_SegmentTree_TimeOut(int[][] matrix) {
    	if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
    		return;
    	leaves = new SquareNode[matrix.length][matrix[0].length];
        this.root = buildTree(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }
    
    private SquareNode buildTree(int[][] matrix, int row1, int col1, int row2, int col2){
    	if(row1 > row2 || col1 > col2)
    		return null;
    	if(row1 == row2 && col1 == col2){
    		leaves[row1][col1] = new SquareNode(row1, col1, matrix[row1][col1]);
    		return leaves[row1][col1];
    	}
    	int midRow = (row1 + row2) / 2, midCol = (col1 + col2) / 2;
    	SquareNode topLeft = buildTree(matrix, row1, col1, midRow, midCol),
    			topRight = buildTree(matrix, row1, midCol+1, midRow, col2),
    			bottomLeft = buildTree(matrix, midRow + 1, col1, row2, midCol),
    			bottomRight = buildTree(matrix, midRow + 1, midCol + 1, row2, col2);
    	SquareNode root = new SquareNode(row1, col1, row2, col2);
    	root.topLeft = topLeft;
    	root.topRight = topRight;
    	root.bottomLeft = bottomLeft;
    	root.bottomRight = bottomRight;
    	if(topLeft != null){
    		topLeft.parent = root;
    		root.sum += topLeft.sum;
    	}
    	if(topRight != null){
    		topRight.parent = root;
    		root.sum += topRight.sum;
    	}
    	if(bottomLeft != null){
    		bottomLeft.parent = root;
    		root.sum += bottomLeft.sum;
    	}
    	if(bottomRight != null){
    		bottomRight.parent = root;
    		root.sum += bottomRight.sum;
    	}
    	return root;
    }
    
    public void update(int row, int col, int val) {
        int diff = val - leaves[row][col].sum;
        SquareNode node = leaves[row][col];
        while(node != null){
        	node.sum += diff;
        	node = node.parent;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegion(root, row1, col1, row2, col2);
    }
    
    public int sumRegion(SquareNode node, int row1, int col1, int row2, int col2){
    	if(row1 == node.row1 && col1 == node.col1 && row2 == node.row2 && col2 == node.col2)
    		return node.sum;
    	
    	int sum = 0;
    	if(node.topLeft != null && row1 <= node.topLeft.row2 && col1 <= node.topLeft.col2)
    		sum += sumRegion(node.topLeft, row1, col1, Math.min(row2, node.topLeft.row2), Math.min(col2, node.topLeft.col2));
    	if(node.topRight != null && row1 <= node.topRight.row2 && col2 >= node.topRight.col1)
    		sum += sumRegion(node.topRight, row1, Math.max(col1, node.topRight.col1), Math.min(row2, node.topRight.row2), col2);
    	if(node.bottomLeft != null && row2 >= node.bottomLeft.row1 && col1 <= node.bottomLeft.col2)
    		sum += sumRegion(node.bottomLeft, Math.max(row1, node.bottomLeft.row1), col1, row2, Math.min(col2, node.bottomLeft.col2));
    	if(node.bottomRight != null && row2 >= node.bottomRight.row1 && col2 >= node.bottomRight.col1)
    		sum += sumRegion(node.bottomRight, Math.max(row1, node.bottomRight.row1), Math.max(col1, node.bottomRight.col1), row2, col2);
    	
    	return sum;
    	
    }
    
    class SquareNode{
    	int row1, col1, row2, col2;
    	int sum;
    	SquareNode topLeft, topRight, bottomLeft, bottomRight;
    	SquareNode parent;
    	SquareNode(int r1, int c1, int r2, int c2){
    		row1 = r1;
    		col1 = c1;
    		row2 = r2;
    		col2 = c2;
    		parent = null;
    	}
    	SquareNode(int r, int c, int value){
    		row1 = row2 = r;
    		col1 = col2 = c;
    		sum = value;
    		parent = null;
    	}
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */