package n411_minimum_unique_word_abbreviation;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
	
	class TrieNode{
		Map<Character, TrieNode> next = null;
		boolean end = false;
	}
	
    public String minAbbreviation(String target, String[] dictionary) {
        TrieNode root = buildTrie(dictionary);
        int binMax = (1 << target.length()), minAbbrev = Integer.MAX_VALUE;
        String minStr = null;
        // abbrevSize array is used for pruning.
        // abbrevSize[i] is the number of components in the string abbreviation represented by i
        int[] abbrevSize = new int[binMax];
        abbrevSize[0] = 1;
        for(int i = 1; i < binMax; i++){
        	abbrevSize[i] = abbrevSize[i-1];
        	int j = 0;
        	while(((i-1) & (1 << j)) != 0) {
        		abbrevSize[i]--;
        		j++;
        	}
        	if(j != 0)
        		abbrevSize[i]++;
        	j++;
        	if(j < target.length() && ((i-1) & (1 << j)) == 0)
        		abbrevSize[i]++;
        }
        for(int i = 0; i < binMax; i++){
        	if(abbrevSize[i] >= minAbbrev) // Pruning
        		continue;
        	if(!search(root, target, i, 0)){
        		StringBuffer buf = new StringBuffer();
        		int tmp = abbrev(buf, target, i);
        		if(tmp < minAbbrev){
        			minStr = buf.toString();
        			minAbbrev = tmp;
        		}
        	}
        }
        return minStr;
    }
    
    private TrieNode buildTrie(String[] dictionary){
    	TrieNode root = new TrieNode();
    	for(String str : dictionary){
    		TrieNode node = root;
    		for(int i = 0; i < str.length(); i++){
    			if(node.next == null)
    				node.next = new HashMap<>();
    			if(!node.next.containsKey(str.charAt(i)))
    				node.next.put(str.charAt(i), new TrieNode());
    			node = node.next.get(str.charAt(i));
    		}
    		node.end = true;
    	}
    	return root;
    }
    
    private boolean search(TrieNode node, String target, int binTarget, int i){
    	if(i == target.length()){
    		if(node.end) return true;
    		return false;
    	}
    	if(node.next == null) return false;
    	
    	if((binTarget & (1<<i)) != 0){
    		if(!node.next.containsKey(target.charAt(i)))
    			return false;
    		return search(node.next.get(target.charAt(i)), target, binTarget, i+1);
    	}
    	
    	for(Entry<Character, TrieNode> entry : node.next.entrySet()){
    		if(search(entry.getValue(), target, binTarget, i+1))
    			return true;
    	}
    	return false;
    }
    
    // Get the string abbreviation represented by binTarget
    private int abbrev(StringBuffer buf, String target, int binTarget){
    	int count = 0, components = 0;
    	for(int i = 0; i < target.length(); i++){
    		if((binTarget & (1 << i)) == 0)
    			count++;
    		else{
    			if(count != 0){
    				buf.append(String.valueOf(count));
    				components++;
    			}
    			buf.append(target.charAt(i));
    			components++;
    			count = 0;
    		}
    	}
    	if(count != 0){
    		buf.append(String.valueOf(count));
    		components++;
    	}
    	return components;
    }
}
