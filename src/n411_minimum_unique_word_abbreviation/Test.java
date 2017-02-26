package n411_minimum_unique_word_abbreviation;

public class Test {
	public static void main(String[] args){
		String target = "apple";
		String[] dictionary = new String[]{
				"blade"
		};
		System.out.println(new Solution().minAbbreviation(target, dictionary));
		
		dictionary = new String[]{
				"plain", "amber", "blade"
		};
		System.out.println(new Solution().minAbbreviation(target, dictionary));
		
		target = "usaandchinaarefriends";
		dictionary = new String[]{};
		System.out.println(new Solution().minAbbreviation(target, dictionary));
	}
}
