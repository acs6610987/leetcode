package n8_string_to_integer;

public class Solution {
	int MAX = ~(1<<31), MIN = 1<<31;
    public int myAtoi(String str) {
    	str = str.trim();
        if(str.length() == 0) return 0;
        int number = 0, sign = 1, i = 0;
        if(str.charAt(i) == '-'){
        	sign = -1;
        	i++;
        }
        else if(str.charAt(i) == '+')
        	i++;
        while(i < str.length()){
        	if(!(str.charAt(i) >= '0' && str.charAt(i) <= '9'))
        		return number;
        	boolean overFlow = false;
        	int timesTwo = number << 1;
        	overFlow = overFlow || (((timesTwo ^ number) >>> 31) == 1);
        	int timesFour = number << 2;
        	overFlow = overFlow || (((timesTwo ^ timesFour) >>> 31) == 1);
        	int timesEight = number << 3;
        	overFlow = overFlow || (((timesFour ^ timesEight) >>> 31) == 1);
        	int timesTen = timesTwo + timesEight;
        	overFlow = overFlow || (((timesEight ^ timesTen) >>> 31) == 1);
        	int digit = (str.charAt(i) - '0')*sign;
        	number = timesTen + digit;
        	overFlow = overFlow || (timesTen != 0 && digit != 0 && ((timesTen ^ number) >>> 31) == 1);
        	if(overFlow)
        		return sign > 0 ? MAX : MIN;
        	i++;
        }
        return number;
    }
}
