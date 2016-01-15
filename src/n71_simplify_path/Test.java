package n71_simplify_path;

public class Test {
	public static void main(String[] args){
		System.out.println(new Solution().simplifyPath("/a/./b/../../c/"));
		System.out.println(new Solution().simplifyPath("/home/"));
	}
}
