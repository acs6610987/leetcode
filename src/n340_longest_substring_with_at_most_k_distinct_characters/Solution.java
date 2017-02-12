package n340_longest_substring_with_at_most_k_distinct_characters;

import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
    	if(s == null || s.length() == 0 || k == 0)
    		return 0;
    	int len = s.length();
    	// x[j][i] is the length of longest substring that ends at j and has at most i distinct characters.
    	int[][] x = new int[len][k+1];
    	for(int i = 1; i <= k; i++){
    		x[0][i] = 1;
    		// occurrence is the set of characters, for the longest substring that ends at j and has at most i distinct characters.
    		HashSet<Character> occurrence = new HashSet<>();
    		occurrence.add(s.charAt(0));
    		for(int j = 1; j < len; j++){
    			int newChar = occurrence.contains(s.charAt(j)) ? 0 : 1;
    			if(occurrence.size() < i){
    				x[j][i] = x[j-1][i] + 1;
    				occurrence.add(s.charAt(j));
    			}
    			else if(newChar == 0){
    				x[j][i] = x[j-1][i] + 1;
    			}
    			else{
    				x[j][i] = x[j-1][i-1] + 1;
    				int rmIndex = j - x[j-1][i-1] - 1;
    				occurrence.remove(s.charAt(rmIndex));
    				occurrence.add(s.charAt(j));
    			}
    		}
    	}
    	int max = 0;
    	for(int i = 0; i < len; i++)
    		if(x[i][k] > max)
    			max = x[i][k];
    	return max;
    }
}