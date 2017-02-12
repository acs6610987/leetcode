package n425_word_squares;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Solution {
	public List<List<String>> wordSquares(String[] words) {
		Hashtable<String, List<String>> prefixTable = new Hashtable<>();
        for(int i = 0; i < words.length; i++){
        	int maxPrefixLen = words[i].length() - 1;
        	for(int j = 0; j <= maxPrefixLen; j++){
        		String prefix = words[i].substring(0, j);
        		if(!prefixTable.containsKey(prefix))
        			prefixTable.put(prefix, new ArrayList<String>());
        		prefixTable.get(prefix).add(words[i]);
        	}
        }
        List<List<String>> results = new ArrayList<List<String>>();
        wordSquaresInternal(prefixTable, new ArrayList<String>(), words[0].length(), results);
        return results;
    }
	
	private void wordSquaresInternal(Hashtable<String, List<String>> prefixTable, List<String> tmpList,
			int wordLen, List<List<String>> results){
		if(tmpList.size() == wordLen){
			List<String> solution = new ArrayList<>(tmpList);
			results.add(solution);
			return;
		}
		
		StringBuffer nextPrefixBuf = new StringBuffer();
		for(int i = 0; i < tmpList.size(); i++)
			nextPrefixBuf.append(tmpList.get(i).charAt(tmpList.size()));
		String nextPrefix = nextPrefixBuf.toString();
		if(!prefixTable.containsKey(nextPrefix))
			return;
		
		List<String> prefixList = prefixTable.get(nextPrefix);
		tmpList.add("");
		for(int i = 0; i < prefixList.size(); i++){
			tmpList.set(tmpList.size() - 1, prefixList.get(i));
			wordSquaresInternal(prefixTable, tmpList, wordLen, results);
		}
		tmpList.remove(tmpList.size() - 1);
	}
}
