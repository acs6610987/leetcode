package n66_plus_one;

public class Solution {
    public int[] plusOne(int[] digits) {
    	if(digits.length == 0) return digits;
        for(int i = digits.length - 1; i >= 0; i--){
        	digits[i] += 1;
        	if(digits[i] == 10)
        		digits[i] = 0;
        	else
        		return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        System.arraycopy(digits, 0, newDigits, 1, digits.length);
        return newDigits;
    }
}
