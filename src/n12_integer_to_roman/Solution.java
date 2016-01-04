package n12_integer_to_roman;

public class Solution {
	int[] basesInt = new int[]{1000, 500, 100, 50, 10, 5, 1};
	char[] basesRoman = new char[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
	char[] romanPair = new char[]{'C', 'C', 'X', 'X', 'I', 'I'};
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        for(int i = 0; i < basesInt.length; i = i+2){
        	int quotient = num / basesInt[i];
        	num = num % basesInt[i];
        	if(quotient % 5 == 4){
        		roman.append(romanPair[i - 2]);
        		roman.append(basesRoman[i - 1 - quotient / 5]);
        		continue;
        	}
        	if(quotient >= 5){
        		roman.append(basesRoman[i-1]);
        		quotient -= 5;
        	}
        	for(int j = 0; j < quotient; j++)
        		roman.append(basesRoman[i]);
        }
        return roman.toString();
    }
}