package n274_H_index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0, tmpHIndex = 0;
        for(int i = citations.length - 1; i >= 0; i--){
        	tmpHIndex = citations.length - i < citations[i] ? citations.length - i : citations[i];
        	if(tmpHIndex > hIndex)
        		hIndex = tmpHIndex;
        	else
        		return hIndex;
        }
        return hIndex;
    }
}