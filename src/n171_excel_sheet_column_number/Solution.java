package n171_excel_sheet_column_number;

public class Solution {
    public int titleToNumber(String s) {
        int num = 0;
        for(int i = 0; i < s.length(); i++)
        	num = num*26 + ((int)s.charAt(i) - (int)'A' + 1);
        return num;
    }
}