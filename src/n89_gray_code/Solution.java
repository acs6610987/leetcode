package n89_gray_code;

import java.util.ArrayList;
import java.util.List;
//
//public class Solution {
//    public List<Integer> grayCode(int n) {
//        List<Integer> pattern = new ArrayList<>();
//        List<Integer> codes = new LinkedList<>();
//        codes.add(0);
//        for(int i = 0; i < n; i++){
//        	int prev = codes.get(codes.size() - 1), patternSize = pattern.size();
//        	prev = prev ^ (1<<i);
//        	codes.add(prev);
//        	pattern.add(1<<i);
//        	for(int j = 0; j < patternSize; j++){
//        		prev = prev ^ pattern.get(j);
//        		codes.add(prev);
//        		pattern.add(pattern.get(j));
//        	}
//        }
//        return codes;
//    }
//}

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> codes = new ArrayList<>();
        codes.add(0);
        for(int i = 0; i < n; i++){
        	int prev = codes.get(codes.size() - 1), patternSize = codes.size();
        	prev = prev ^ (1<<i);
        	codes.add(prev);
        	for(int j = 1; j < patternSize; j++){
        		prev = prev ^ (codes.get(j) ^ codes.get(j-1));
        		codes.add(prev);
        	}
        }
        return codes;
    }
}