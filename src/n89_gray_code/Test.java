package n89_gray_code;

import java.util.List;

public class Test {
	public static void main(String[] args){
		List<Integer> list = new Solution().grayCode(3);
		for(int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}
}
