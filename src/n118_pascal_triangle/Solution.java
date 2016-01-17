package n118_pascal_triangle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new LinkedList<>();
        if(numRows == 0) return triangle;
        List<Integer> lastRow = new ArrayList<>(), row;
        lastRow.add(1);
        triangle.add(lastRow);
        for(int i = 1; i < numRows; i++){
        	row = new ArrayList<>(lastRow.size() + 1);
        	row.add(1);
        	for(int j = 0; j < lastRow.size() - 1; j++)
        		row.add(lastRow.get(j) + lastRow.get(j+1));
        	row.add(1);
        	triangle.add(row);
        	lastRow = row;
        }
        return triangle;
    }
}