package n126_word_ladder_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    	LinkedList<List<String>> paths = new LinkedList<>();
    	HashMap<String, Set<String>> parents = new HashMap<>();
    	Queue<String> bfsQueue = new LinkedList<>();
    	bfsQueue.add(beginWord);
    	while(!bfsQueue.isEmpty()){
    		int currentSize = bfsQueue.size();
        	Set<String> nextWords = new HashSet<>();
        	boolean terminate = false;
    		for(int i = 0; i < currentSize; i++){
    			String word = bfsQueue.poll(), adjacentWord;
    			StringBuilder adjacentWordBuilder = new StringBuilder(word);
    			for(int j = 0; j < word.length(); j++){
    				for(char k = 'a'; k <= 'z'; k++){
    					if(k == word.charAt(j)) continue;
    					adjacentWordBuilder.setCharAt(j, k);
    					adjacentWord = adjacentWordBuilder.toString();
    					if(adjacentWord.equals(endWord)){
    						if(!parents.containsKey(endWord))
    							parents.put(endWord, new HashSet<String>());
    						parents.get(endWord).add(word);
    						terminate = true;
    					}
    					if(wordList.contains(adjacentWord)){
    				    	nextWords.add(adjacentWord);
    						if(!parents.containsKey(adjacentWord))
    							parents.put(adjacentWord, new HashSet<String>());
    						parents.get(adjacentWord).add(word);
    					}
    				}
    				adjacentWordBuilder.setCharAt(j, word.charAt(j));
    			}
    		}
    		if(terminate) break;
    		bfsQueue.addAll(nextWords);
    		wordList.removeAll(nextWords);
    	}
    	List<String> path = new LinkedList<>();
    	path.add(endWord);
    	paths.add(path);
    	while(!paths.isEmpty() && paths.get(0).get(0) != beginWord){
    		int currentSize = paths.size();
    		for(int i = 0; i < currentSize; i++){
    			path = paths.poll();
    			Set<String> tmpParents = parents.get(path.get(0));
    			if(tmpParents == null) return paths;
    			for(String p : tmpParents){
    				LinkedList<String> newPath = new LinkedList<>(path);
    				newPath.addFirst(p);
    				paths.add(newPath);
    			}
    		}
    	}
    	return paths;
    }
}
