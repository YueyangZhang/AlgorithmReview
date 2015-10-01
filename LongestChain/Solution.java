package LongestChain;

import java.util.HashMap;
import java.util.Set;

public class Solution {
	
	HashMap<String, Integer> map = new HashMap<>();
	
	public int longestChain(Set<String> dict) {
		int rst = 0;
		for (String s:dict) {
			int count = helper(dict, s);
			rst = Math.max(rst, count);
		}
		
		return rst;
	}

	private int helper(Set<String> dict, String s) {
		
		if (map.containsKey(s)) {
			return map.get(s);
		}
		
		if (s.length() == 1) {
			map.put(s, 1);
			return 1;
		}
		
		int count = 0;
		for (int j = 0; j < s.length(); j++) {
			StringBuilder sb = new StringBuilder(s);
			sb.deleteCharAt(j);
			String newS = sb.toString();
			if (dict.contains(newS)) {
				count = Math.max(count, helper(dict, newS)+ 1);
			} else {
				count = Math.max(count,1);
			}
			
			map.put(s, count);
		}
		return count;
	}
}
