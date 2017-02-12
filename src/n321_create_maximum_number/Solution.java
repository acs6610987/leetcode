package n321_create_maximum_number;

import java.util.Arrays;
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
    	int m = nums1.length, n = nums2.length;
    	// We first create the maximum number by using only one array
    	// Dx[i-1][j-1] is the index of the first digit of the maximum number
    	// of length j, by using numbers numsx[m - i], ..., numsx[m - 1]
    	int[][] D1 = new int[m][k], D2 = new int[n][k];
    	for(int j = 1; j <= Math.min(k, m); j++){
    		for(int i = j; i <= m; i++){
    			D1[i-1][j-1] = m - i; // First assume we use nums1[m-i] as the first digit.
    			if(i-2 >= j-1){
    				if(nums1[m-i] < nums1[D1[i-2][j-1]]) // nums1[m-i] can be ignored because using it as the first digit is not the maximum.
    					D1[i-1][j-1] = D1[i-2][j-1];
    			}
    		}
    	}
    	for(int j = 1; j <= Math.min(k, n); j++){
    		for(int i = j; i <= n; i++){
    			D2[i-1][j-1] = n - i;
    			if(i-2 >= j-1){
    				if(nums2[n-i] < nums2[D2[i-2][j-1]])
    					D2[i-1][j-1] = D2[i-2][j-1];
    			}
    		}
    	}
    	int[] result = new int[k];
    	Arrays.fill(result, -1);
    	for(int x = Math.max(0, k - n); x <= Math.min(k,  m); x++){
    		int y = k - x, i1 = m, i2 = n, j1 = x, j2 = y;
    		int[] maxNums1 = new int[x], maxNums2 = new int[y];
    		while(j1 > 0){
    			maxNums1[x - j1] = nums1[D1[i1 - 1][j1 - 1]];
    			i1 = m - D1[i1 - 1][j1 - 1] - 1;
    			j1--;
    		}
    		while(j2 > 0){
    			maxNums2[y - j2] = nums2[D2[i2 - 1][j2 - 1]];
    			i2 = n - D2[i2 - 1][j2 - 1] - 1;
    			j2--;
    		}
    		int runStart1 = 0, runEnd1 = 0, runStart2 = 0, runEnd2 = 0;
    		int[] tmpResult = new int[k];
    		Arrays.fill(tmpResult, -1);
    		for(int i = 0, j = 0, r = 0; r < k; r++){
    			tmpResult[r] = greater(maxNums1, i, maxNums2, j) ? 
    					maxNums1[i++] : maxNums2[j++];
    		}
    		int i = 0;
    		boolean foundBigger = false;
    		while(i < k){
    			if(!foundBigger && tmpResult[i] < result[i])
    				break;
    			if(tmpResult[i] > result[i])
    				foundBigger = true;
    			result[i] = tmpResult[i];
    			i++;
    		}
    	}
    	return result;
    		
    }
    
    private boolean greater(int[] nums1, int i, int[] nums2, int j){
    	while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }
}