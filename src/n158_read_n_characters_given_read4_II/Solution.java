package n158_read_n_characters_given_read4_II;

/* The read4 API is defined in the parent class Reader4.
int read4(char[] buf); */

public class Solution extends Reader4 {
	char[] buf4 = new char[4];
	int next = 0, remaining = 0;
	/**
	* @param buf Destination buffer
	* @param n   Maximum number of characters to read
	* @return    The number of characters read
	*/
	public int read(char[] buf, int n) {
		int i = 0, j = 0;
		while(n > 0){
			for(j = 0; j < Math.min(remaining, n); j++)
				buf[i++] = buf4[next++];
			remaining -= j;
			n -= j;
			if(remaining == 0){
				remaining = read4(buf4);
				next = 0;
				if(remaining == 0)
					break;
			}
		}
		return i;
	}
}