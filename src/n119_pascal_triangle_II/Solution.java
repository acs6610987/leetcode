package n119_pascal_triangle_II;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>(rowIndex+1);
        int num = 0;
        for(int i = 0; i <= rowIndex; i++){
        	num = 0;
        	for(int j = 0; j < i; j++){
        		int tmp = row.get(j);
        		row.set(j, num + row.get(j));
        		num = tmp;
        	}
        	row.add(1);
        }
        return row;
    }
}