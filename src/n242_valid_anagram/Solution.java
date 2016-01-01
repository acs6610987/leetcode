package n242_valid_anagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
    	if(s == null && t == null) return true;
    	if(s == null && t != null) return false;
    	if(s != null && t == null) return false;
    	if(s.length() != t.length()) return false;
    	
        int[] sChars = new int[26];
        int[] tChars = new int[26];
        for(int i = 0; i < s.length(); i++){
        	sChars[(int)s.charAt(i) - (int)'a']++;
        	tChars[(int)t.charAt(i) - (int)'a']++;
        }
        for(int i = 0; i < 26; i++)
        	if(sChars[i] != tChars[i])
        		return false;
        return true;
    }
}