package n425_word_squares;

import java.util.List;

public class Test {
	public static void main(String[] args){
		String[] words = new String[]{
				"area", "lead", "wall", "lady", "ball"
		};
		List<List<String>> results = new Solution().wordSquares(words);
		for(int i = 0; i < results.size(); i++){
			for(int j = 0; j < results.get(i).size(); j++){
				System.out.println(results.get(i).get(j));
			}
			System.out.println();
		}
	}
}
