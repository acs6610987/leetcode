package n258_add_digits;

/*
 * Because (10a+b)%9 == (a+b)%9
 */
public class Solution {
    public int addDigits(int num) {
    	if(num == 0) return 0;
        return num%9 == 0? 9 : num%9;
    }
}