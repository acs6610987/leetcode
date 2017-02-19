package n358_rearranging_string_k_distance_apart;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public String rearrangeString(String s, int k) {
    	if(k == 0 || k == 1) return s;
        Map<Integer, LinkedList<Character>> freqMap = new HashMap<>();
        int[] charFreq = new int[26];
        for(int i = 0; i < s.length(); i++)
        	charFreq[s.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++){
        	if(!freqMap.containsKey(charFreq[i]))
        		freqMap.put(charFreq[i], new LinkedList<Character>());
        	freqMap.get(charFreq[i]).add((char)('a' + i));
        }
        StringBuffer buf = new StringBuffer();
        int i = s.length();
        while(i > 0){
        	while(i > 0 && (!freqMap.containsKey(i) || freqMap.get(i).size() == 0))
        		i--;
        	if(i == 0) break;
        	boolean[] seg = new boolean[26];
        	int tmp = i;
        	for(int j = 0; j < k; j++){
        		while(tmp > 0 
        				&& (!freqMap.containsKey(tmp) 
        						|| freqMap.get(tmp).size() == 0
        						|| seg[freqMap.get(tmp).peek() - 'a'])){
        			tmp--;
        		}
        		if(tmp == 0) {
        			i = 0;
        			break;
        		}
        		char next = freqMap.get(tmp).poll();
        		seg[next - 'a'] = true;
        		buf.append(next);
        		if(!freqMap.containsKey(tmp - 1))
        			freqMap.put(tmp-1, new LinkedList<Character>());
        		freqMap.get(tmp-1).add(next);
        	}
        }
        if(buf.length() != s.length()) return "";
        return buf.toString();
    }
}