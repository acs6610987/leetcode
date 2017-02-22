package n159_longest_substring_with_at_most_two_distinct_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
    	if(null == s || 0 == s.length())
    		return 0;
    	Map<Character, Integer> freqMap = new HashMap<>();
    	int longest = 0, windowSize = 0, distinct = 0;
    	for(int i = 0; i < s.length(); i++){
    		if(freqMap.getOrDefault(s.charAt(i), 0) > 0)
    			freqMap.put(s.charAt(i), freqMap.get(s.charAt(i)) + 1);
    		else{
    			if(distinct == 2){
	    			for(int j = i - windowSize; j < i; j++){
	    				windowSize--;
	    				char c = s.charAt(j);
	    				freqMap.put(c, freqMap.get(c) - 1);
	    				if(freqMap.get(c) == 0){
	    					distinct--;
	    					break;
	    				}
	    			}
    			}
    			freqMap.put(s.charAt(i), 1);
    			distinct++;
    		}
    		windowSize++;
    		longest = Math.max(longest, windowSize);
    	}
        return longest;
    }
}