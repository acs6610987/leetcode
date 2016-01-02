package n318_maximum_product_of_word_lengths;

public class Solution {
    public int maxProduct(String[] words) {
        Record[] records = new Record[words.length];
        for(int i = 0; i < words.length; i++)
        	records[i] = new Record(words[i]);
        
        int max = 0;
        for(int i = 0; i < records.length; i++)
        	for(int j = 0; j < records.length; j++){
        		if(records[i].length * records[j].length <= max)
        			continue;
        		if((records[i].bits & records[j].bits) == 0)
        			max = records[i].length * records[j].length;
        	}
        return max;
    }
    
    class Record{
    	int bits;
    	int length;
    	Record(String word){
    		length = word.length();
    		for(int i = 0; i < length; i++)
    			bits |= 1 << ((int)word.charAt(i) - (int)'a');
    	}
    }
}