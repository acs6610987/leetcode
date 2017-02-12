package n388_longest_absolute_file_path;

public class Test {
	public static void main(String[] args){
		String str = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(new Solution().lengthLongestPath(str));
	}
}
