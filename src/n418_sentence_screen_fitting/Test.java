package n418_sentence_screen_fitting;

public class Test {
	public static void main(String[] args){
		String[] sentence = new String[]{
				"I", "had", "apple", "pie"
		};
		int rows = 4, cols = 5;
		System.out.println(new Solution().wordsTyping(sentence, rows, cols));
		
		sentence = new String[]{
				"a", "bcd", "e"
		};
		rows = 3; cols = 6;
		System.out.println(new Solution().wordsTyping(sentence, rows, cols));
		
		sentence = new String[]{
				"hello", "world"
		};
		rows = 2; cols = 8;
		System.out.println(new Solution().wordsTyping(sentence, rows, cols));
	}
}
