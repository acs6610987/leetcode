package n127_word_ladder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
    	int distance = 1;
    	Queue<String> bfsQueue = new LinkedList<>();
    	bfsQueue.add(beginWord);
    	while(!bfsQueue.isEmpty()){
    		distance++;
    		int currentSize = bfsQueue.size();
    		for(int i = 0; i < currentSize; i++){
    			String word = bfsQueue.poll();
    			StringBuilder adjacentWord = new StringBuilder(word);
    			for(int j = 0; j < word.length(); j++){
    				for(int k = 0; k < 26; k++){
    					if('a'+k == (int)word.charAt(j)) continue;
    					adjacentWord.setCharAt(j, (char)('a'+k));
    					if(adjacentWord.toString().equals(endWord))
    						return distance;
    					if(wordList.contains(adjacentWord.toString())){
    						wordList.remove(adjacentWord.toString());
    						bfsQueue.add(adjacentWord.toString());
    					}
    				}
    				adjacentWord.setCharAt(j, word.charAt(j));
    			}
    		}
    	}
    	return 0;
    }
}