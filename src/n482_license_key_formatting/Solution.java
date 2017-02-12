package n482_license_key_formatting;

public class Solution {
	public String licenseKeyFormatting(String S, int K) {
        StringBuffer buf = new StringBuffer();
        int groupCount = 0;
        for(int i = S.length() - 1; i >= 0; i--){
        	if(S.charAt(i) == '-') continue;
        	buf.append(S.charAt(i));
        	groupCount++;
        	if(groupCount == K){
        		buf.append('-');
        		groupCount = 0;
        	}
        }
        if(buf.length() > 0 && buf.charAt(buf.length() - 1) == '-')
        	buf.deleteCharAt(buf.length() - 1);
        buf.reverse();
        return buf.toString().toUpperCase();
    }
}
