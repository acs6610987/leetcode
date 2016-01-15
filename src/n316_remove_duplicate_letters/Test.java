package n316_remove_duplicate_letters;

public class Test {
	public static void main(String[] args){
		String s = "bcabc";
		System.out.println(new Solution().removeDuplicateLetters(s));
		s = "cbccdcbc";
		System.out.println(new Solution().removeDuplicateLetters(s));
		s = "cbacdcbc";
		System.out.println(new Solution().removeDuplicateLetters(s));
		s = "wmxkuuoordmnpnebikzzujdpscpedcrsjphcaykjsmobturjjxxpoxvvrynmapegvtlasmyuddgxygkaztmbpkrnukbxityz";
		System.out.println(new Solution().removeDuplicateLetters(s));
	}
}
