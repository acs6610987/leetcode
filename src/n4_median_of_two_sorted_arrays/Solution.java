package n4_median_of_two_sorted_arrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int candidateIndex = findMedianCandidate(nums1, nums2);
        if(candidateIndex >= 0)
        	return computeMedian(nums1, candidateIndex, nums2);
        else{
        	candidateIndex = findMedianCandidate(nums2, nums1);
        	return computeMedian(nums2, candidateIndex, nums1);
        }
    }
    
    /* We define a median candidate to be:
     * (i) the median if (m + n) is an odd number;
     * (ii) the second median integer if (m + n) is an even number.
     * In this function, suppose the median candidate is in "nums1", find its index;
     * if it is not in "nums1", we return -1. */
    private int findMedianCandidate(int[] nums1, int[] nums2){
    	int m = nums1.length, n = nums2.length, k = (m + n) / 2;
    	if(n == 0) return m / 2;
    	int left = 0, right = m - 1;
    	while(left <= right){
    		int testIndex1 = (left + right) / 2, testIndex2 = k - testIndex1 - 1;
    		if(testIndex2 < -1 
    				|| (testIndex2 < n-1 && nums1[testIndex1] > nums2[testIndex2 + 1])){
    			right = testIndex1 - 1;
    		}
    		else if(testIndex2 >= n 
    				|| (testIndex2 >= 0 && nums1[testIndex1] < nums2[testIndex2])){
    			left = testIndex1 + 1;
    		}
    		else
    			return testIndex1;
    	}
    	return -1;
    }
    
    private double computeMedian(int[] nums1, int candidateIndex, int[] nums2){
    	int m = nums1.length, n = nums2.length, k = (m + n) / 2;
    	if((m + n) % 2 == 1)
    		return nums1[candidateIndex];
    	int second = k - candidateIndex - 1;
    	if(second < 0 || second >= n)
    		return (nums1[candidateIndex - 1] + nums1[candidateIndex]) * 1.0 / 2;
    	if(candidateIndex == 0 || nums2[second] > nums1[candidateIndex - 1])
    		return (nums1[candidateIndex] + nums2[second]) * 1.0 / 2;
    	return (nums1[candidateIndex - 1] + nums1[candidateIndex]) * 1.0 / 2;
    }
}