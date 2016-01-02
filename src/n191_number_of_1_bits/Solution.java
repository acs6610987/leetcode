package n191_number_of_1_bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        for(int i = 0; i < 32; i++){
        	if(((n>>>i) & 1) != 0)
        		weight++;
        }
        return weight;
    }
}