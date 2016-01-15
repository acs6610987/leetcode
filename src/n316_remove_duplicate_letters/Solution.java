package n316_remove_duplicate_letters;

import java.util.PriorityQueue;

public class Solution {
    public String removeDuplicateLetters(String s) {
    	if(s == null || s.length() == 0) return s;
        int[] charBitMap = new int[s.length()];
        //charBitMap[i] sets its k-th bit to 1 if letter 'a'+k exists from s[i] to the end
        charBitMap[s.length() - 1] = 1 << (s.charAt(s.length() - 1) - 'a');
        for(int i = s.length() - 2; i >= 0; i--)
        	charBitMap[i] = charBitMap[i+1] | (1 << (s.charAt(i) - 'a'));
        
        StringBuilder result = new StringBuilder();
        int takenChars = 0xFFFFFFFF, curBitMap = 0, i = 0, lastIndex = -1;
        PriorityQueue<QueueChar> queue = new PriorityQueue<>();
        //Invariant: all elements in the queue should have the same bitmap
        //Algorithm: to get the next letter in the result, pops the smallest letter from the queue
        //Because we know all elements in the queue have the same bitmap, poping out any one of them
        //will not affect having the others in the result later, hence we can just pop the smallest one
        //in order to get the smallest lexicographical order.
        while(i < s.length() || !queue.isEmpty()){
        	if(i < s.length() && (charBitMap[i] & takenChars) == curBitMap){
        		queue.add(new QueueChar(s.charAt(i), i));
        		i++;
        	}
        	else{
        		QueueChar next = null;
        		while(!queue.isEmpty()){
        			next = queue.poll();
        			if((next.index > lastIndex) && ((1<<(next.c - 'a') & takenChars) != 0)){
        				result.append(next.c);
            			takenChars &= ~(1<<(next.c - 'a'));
            			lastIndex = next.index;
            			curBitMap = charBitMap[lastIndex] & takenChars;
        				break;
        			}
        		}
        		if(queue.isEmpty() && i < s.length()) curBitMap = charBitMap[i] & takenChars;
        	}
        }
        return result.toString();
    }
    
    class QueueChar implements Comparable<QueueChar>{
    	char c;
    	int index;
    	QueueChar(char c, int index){
    		this.c = c;
    		this.index = index;
    	}
		@Override
		public int compareTo(QueueChar o) {
			if(this.c != o.c)
				return this.c - o.c;
			return this.index - o.index;
		}
    }
}