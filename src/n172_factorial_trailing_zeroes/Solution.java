package n172_factorial_trailing_zeroes;

public class Solution {
    public int trailingZeroes(int n) {
//        int numOfFactors5 = 0, power5 = 5, numOfFactors2 = 0, power2 = 2;
//        while(n / power5 > 0 || n / power2 > 0){
//        	numOfFactors5 += n / power5;
//        	power5 *= 5;
//        	numOfFactors2 += n / power2;
//        	power2 *= 2;
//        }
//        return (numOfFactors5 > numOfFactors2 ? numOfFactors2 : numOfFactors5);
    	
    	int zeroes = 0, denominator = 5;
        while(n / denominator > 0){
        	zeroes += n / denominator;
        	int tmp = denominator;
        	denominator <<= 1;
        	if(denominator < 0) break;
        	denominator <<= 1;
        	if(denominator < 0) break;
        	denominator += tmp;
        	if(denominator < 0) break;
        }
        return zeroes;
    }
}
