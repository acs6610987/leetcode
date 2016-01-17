package n275_H_index_II;

public class Solution {
    public int hIndex(int[] citations) {
    	if(citations.length == 0) return 0;
    	int left = 0, right = citations.length - 1, pivot = 0;
        while(left < right){
        	pivot = (left + right) / 2;
        	if(citations[pivot] > citations.length - pivot)
        		right = pivot;
        	else if(citations[pivot] < citations.length - pivot)
        		left =  pivot + 1;
        	else
        		return citations[pivot];
        		
        }
        return citations[left] < citations.length - pivot ? citations[left] : citations.length - left;
    }
}