package n269_alien_dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class Solution {
    public String alienOrder(String[] words) {
    	if(null == words || words.length == 0)
    		return "";
        Set<Character>[] orderGraph = new HashSet[26];
        for(int i = 0; i < 26; i++)
        	orderGraph[i] = new HashSet<Character>();
        int[] degree = new int[26]; // In degree of a char
        Arrays.fill(degree, -1);
        for(int i = 0; i < words.length; i++)
        	for(int j = 0; j < words[i].length(); j++)
        		degree[words[i].charAt(j) - 'a'] = 0;
        		
        for(int i = 0; i < words.length - 1; i++){
        	int minLen = Math.min(words[i].length(), words[i+1].length()), j = 0;
        	for(j = 0; j < minLen; j++){
        		if(words[i].charAt(j) == words[i+1].charAt(j))
        			continue;
        		else{
        			if(!orderGraph[words[i].charAt(j) - 'a'].contains(words[i+1].charAt(j)))
        				degree[words[i+1].charAt(j) - 'a']++;
	        		orderGraph[words[i].charAt(j) - 'a'].add(words[i+1].charAt(j));
	        		break;
        		}
        	}
        	if(j == minLen && words[i].length() > words[i+1].length()) // If word A is the prefix of word B, then A should appear before B  
        		return "";
        }
        
        Queue<Character> queue = new LinkedList<Character>();
        int numOfChars = 0;
        for(int i = 0; i < 26; i++){
        	if(degree[i] == 0)
        		queue.add((char)('a' + i));
        	if(degree[i] != -1)
        		numOfChars++;
        }
        
        StringBuffer buf = new StringBuffer();
        while(!queue.isEmpty()){
        	char c = queue.poll();
    		buf.append(c);
        	for(char next : orderGraph[c - 'a']){
    			degree[next - 'a'] --;
    			if(degree[next - 'a'] == 0) 
    				queue.add(next);
        	}
        }
        if(buf.length() < numOfChars) // Detect cycle
        	return "";
        
        return buf.toString();
    }
   
}