package n172_factorial_trailing_zeroes;

public class Solution {
    public int trailingZeroes(int n) {    	
    	int numOfFactors5 = 0, power5 = 5;
        while(n / power5 > 0){
        	numOfFactors5 += n / power5;
        	int tmp = power5;
        	power5 <<= 1;
        	if(power5 < 0) break;
        	power5 <<= 1;
        	if(power5 < 0) break;
        	power5 += tmp;
        	if(power5 < 0) break;
        }
        return numOfFactors5;
    }
}
