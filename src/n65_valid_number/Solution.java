package n65_valid_number;

public class Solution {
    public boolean isNumber(String s) {
    	s = s.trim();
    	if(s.length() == 0) return false;
        int i = 0, eIndex = 0;
        while(eIndex < s.length() && s.charAt(eIndex) != 'e') eIndex++;
        //First part of the scientific number
        boolean	firstIsFraction = true, hasNumbers = false;
        int decimalPoints = 0;
        if(s.charAt(i) == '-' || s.charAt(i) == '+')
        	i++;
        while(i < eIndex) {
        	if(s.charAt(i) == '.')
        		decimalPoints++;
        	else if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
        		hasNumbers = true;
        	else
        		firstIsFraction = false;
        	i++;
        }
        firstIsFraction = firstIsFraction && hasNumbers && (decimalPoints <= 1);
        
        //Second part of the scientific number
        i = eIndex+1;
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+'))
	        i++;
        boolean secondIsInteger = (i < s.length());
        while(i < s.length()) {
        	if(!(s.charAt(i) >= '0' && s.charAt(i) <= '9'))
        		secondIsInteger = false;
        	i++;
        }

        if(eIndex < s.length()) return firstIsFraction && secondIsInteger;
        return firstIsFraction;
    }
}