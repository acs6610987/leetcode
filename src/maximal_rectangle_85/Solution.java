package maximal_rectangle_85;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
    	if(matrix.length == 0) return 0;
    	int height = matrix.length, width = matrix[0].length;
        int[][] runLenMatrix = new int[height][width];
        //runLenMatrix[i][j] means the number of continuous '1's, starting from point (i, j) and walking along the j-th column
        for(int i = 0; i < width; i++){
        	runLenMatrix[height - 1][i] = (matrix[height - 1][i] == '1'? 1 : 0);
        	for(int j = height - 2; j >= 0 ; j--)
        		runLenMatrix[j][i] = (matrix[j][i] == '1'? (runLenMatrix[j + 1][i] + 1) : 0);
        }
        //First, we could define dp = new int[height][width][height]
        //Then dp[i][j][k] means the width of the maximal rectangle whose top-left point is (i, j) and whose height is k
        //Hence, dp[i][j][k] = dp[i][j+1][k] + 1
        //However, this dp matrix is too big, we could simplify it:
        //1. dp[i+1][*][*] has no relation with dp[i][*][*], so we could delete the first dimension
        //2. dp[i][j][*] is only related with dp[i][j+1][*], so we can just set the second dimension to 2
        //Therefore, dp could be simplified to new int[2][height]
        int[][] dp = new int[2][height];
        int maxArea = 0;
        for(int i = 0; i < height; i++){
        	for(int j = 0; j < height; j++)
        		dp[width%2][j] = 0;
        	for(int j = width - 1; j >= 0; j--){
        		for(int k = 0; k < height; k++)
        			dp[j%2][k] = 0;
        		for(int k = 1; k <= runLenMatrix[i][j]; k++){
        			dp[j%2][k-1] = dp[(j+1)%2][k-1] + 1;
        			if(maxArea < dp[j%2][k-1] * k)
        				maxArea = dp[j%2][k-1] * k;
        		}
        	}
        }
        return maxArea;
    }
}
