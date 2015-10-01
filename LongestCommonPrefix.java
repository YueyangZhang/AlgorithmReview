
public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = 0;
        for (int i = 0; i < prefix.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (prefix.charAt(i) == strs[j].charAt(i)){
                    continue;
                }
                break;
            }
            count += 1;
        }
        
        return prefix.substring(0, count);
    }
}
