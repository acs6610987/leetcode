package n308_range_sum_query_2d_mutable;

/*
 * Binary Indexed Tree (BIT)
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 */

/* 
 * Now I only explain for one-dimension BIT, two dimension is the same.
 * 
 * BITree uses the idea that each size number can be decomposed to a sum of 
 * 2's exponents, for example, if we want to sum from arr[0] to arr[9], then
 * the size is 10 = 8 + 2, and BITree maintains two elements: 
 * (1) BITree[8]: sum from arr[0] to arr[7]
 * (2) BITree[10]: sum from arr[8] to arr[9] 
 * 
 * BITree[i] keeps the sum from arr[(i - (i & (-i)) - 1] (exclusive) to arr[i-1] (inclusive)
 * (i & (-i)) is the decimal value by keeping only the least significant bit 1 of i.
 * For example, if i = 10, its binary is 1010, and (i - (i & (-i))) is 1000, 
 * then BITree[10] keeps the sum from arr[1000 - 1] (exclusive) to arr[1010 - 1] (inclusve),
 * meaning arr[8] + arr[9].
 * 
 * If we iteratively apply (i - (i & (-i))), until 0, the process is equivalent to resetting the
 * least significant bit 1, one by one, and then we will have the decomposed sums in the
 * corresponding BITree elements.
 * 
 * Above is the process when we want to sum from arr[0] to arr[i-1], costing O(log(n)).
 * 
 * How about updating arr[i-1]?
 * Well, now we need to think about which BITree element has arr[i-1] included in its sum.
 * For sure, BITree[i] is one of them. Which else? Suppose BITree[x] is one of them, then we have
 * x - (x & (-x)) <= i - 1 <= x - 1
 * so x >= i.
 * Think about this: which number is bigger than i, but if we reset its least significant bit 1, it becomes smaller than i (i.e., <= i-1)?
 * Denote 'p1' to be the position of this number's least significant bit 1, and 'p2' to be the position of i's least significant
 * bit 1.
 * number x satisfies the following condition:
 * p1 > p2, and the bit of i on position p1 is 0, and all higher-position bits of x are the same as those of i.
 * 
 * How do we compute such a x? Well, we can just iteratively update i = i + (i & (-i)). Each updated i is a satisfying x. This works 
 * because adding the decimal value corresponding to least significant bit 1 is equivalent to resetting bits 1 until we have a bit 0.
 */

public class NumMatrix {
	int[][] BITree;
	int[][] matrix;
	
	public NumMatrix(int[][] matrix){
		if(null == matrix || 0 == matrix.length || 0 == matrix[0].length)
			return;
		this.matrix = new int[matrix.length][matrix[0].length];
		this.BITree = new int[matrix.length + 1][matrix[0].length + 1];
		for(int i = 0; i < matrix.length; i++)
			for(int j = 0; j < matrix[0].length; j++)
				update(i, j, matrix[i][j]);
	}
	
	
	public void update(int row, int col, int val){
		int diff = val - this.matrix[row][col];
		this.matrix[row][col] = val;
		for(int i = row + 1; i < BITree.length; i = i + (i & (-i))){
			for(int j = col + 1; j < BITree[0].length; j = j + (j & (-j))){
				BITree[i][j] += diff;
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2){
		return sumFromOrigin(row1 - 1, col1 - 1) 
				+ sumFromOrigin(row2, col2)
				- sumFromOrigin(row2, col1 - 1)
				- sumFromOrigin(row1 - 1, col2);
	}
	
	public int sumFromOrigin(int row, int col){
		int sum = 0;
		for(int i = row + 1; i > 0; i -= (i & (-i))){
			for(int j = col + 1; j > 0; j -= (j & (-j))){
				sum += BITree[i][j];
			}
		}
		return sum;
	}
}
