package n212_word_search_II;

import java.util.List;

public class Test {
	public static void main(String[] args){
		String[] words = new String[]{"oath", "pea", "eat", "rain"};
		char[][] board = new char[][]{
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		List<String> result = new Solution().findWords(board, words);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
		
		
		words = new String[]{
				"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
		board = new char[][]{
				{'a', 'b'},
				{'c', 'd'}
		};
		result = new Solution().findWords(board, words);
		for(int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));
	}
}
