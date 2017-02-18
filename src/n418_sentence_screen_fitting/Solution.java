package n418_sentence_screen_fitting;

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
    	// lineWords[i] is the maximum number of the consecutive words, starting from sentence[i], that could
    	// fit into one single line.
    	int[] lineWords = new int[sentence.length];
        for(int i = 0; i < sentence.length; i++){
        	if(sentence[i].length() > cols)
        		return 0;
        	lineWords[i] = 1;
        	int remainingSpace = cols - sentence[i].length(), j = (i + 1) % sentence.length;
        	while(remainingSpace >= 1 + sentence[j].length()){
        		lineWords[i]++;
        		remainingSpace -= (1 + sentence[j].length());
        		j = (j + 1) % sentence.length;
        	}
        }
        int fittingWordNum = 0, wordIndex = 0;
        for(int i = 0; i < rows; i++){
        	fittingWordNum += lineWords[wordIndex];
        	wordIndex = (wordIndex + lineWords[wordIndex]) % sentence.length;
        }
        return fittingWordNum / sentence.length;
    }
}