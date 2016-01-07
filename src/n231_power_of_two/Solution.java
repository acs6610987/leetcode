package n231_power_of_two;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        int i = 0;
        while(i < 31){
        	if((1 << i) == n)
        		return true;
        	i++;
        }
        return false;
    }
}
