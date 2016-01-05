package n202_happy_number;

import java.util.HashSet;

public class Solution {
	HashSet<Integer> numbers = new HashSet<>();
    public boolean isHappy(int n) {
        int next = 0;
        numbers.add(n);
        while(n != 1){
        	next = 0;
        	while(n != 0) {
        		next += (n%10) * (n%10);
        		n /= 10;
        	}
        	if(numbers.contains(next))
        		return false;
        	numbers.add(next);
        	n = next;
        }
        return true;
    }
}