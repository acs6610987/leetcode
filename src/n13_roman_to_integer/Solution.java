package n13_roman_to_integer;

import java.util.HashMap;

public class Solution {
	HashMap<Character, Integer> charToInt = new HashMap<>();
	{
		charToInt.put('I', 1);
		charToInt.put('V', 5);
		charToInt.put('X', 10);
		charToInt.put('L', 50);
		charToInt.put('C', 100);
		charToInt.put('D', 500);
		charToInt.put('M', 1000);
	}
	HashMap<Character, Character> charCouple = new HashMap<>();
	{
		charCouple.put('I', null);
		charCouple.put('V', 'I');
		charCouple.put('X', 'I');
		charCouple.put('L', 'X');
		charCouple.put('C', 'X');
		charCouple.put('D', 'C');
		charCouple.put('M', 'C');
	}
    public int romanToInt(String s) {
        int arabic = 0;
        for(int i = s.length() - 1; i >= 0; i--){
        	int tmp = charToInt.get(s.charAt(i));
        	if(i > 0 && charCouple.get(s.charAt(i)) != null && s.charAt(i-1) == charCouple.get(s.charAt(i))){
        		tmp -= charToInt.get(s.charAt(i-1));
        		i--;
        	}
        	arabic += tmp;
        }
        return arabic;
    }
}