package LongestChain;

import java.util.HashSet;
import java.util.Set;

public class Result {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("abcdef");
		dict.add("abcde");
		dict.add("abce");
		dict.add("abe");
		dict.add("ae");
		dict.add("e");
		dict.add("abcd");
		dict.add("abc");
		dict.add("ab");
		dict.add("b");
		Solution s = new Solution();
		
		System.out.println(s.longestChain(dict));
		
	}
}
