package n318_maximum_product_of_word_lengths;

public class Test {
	public static void main(String[] args){
		String[] words = new String[]{
				"abcw", "baz", "foo", "bar", "xtfn", "abcdef"
		};
		System.out.println(new Solution().maxProduct(words));
	}
}
