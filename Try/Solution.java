package Try;





public class Solution {
    public String check(String s) {
    	if (s == null || s.length() <= 1) {
    		return s;
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		int count = 1;
    		while (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
    			i++;
    			count++;
    		}
    		
    		sb.append(s.charAt(i));
    		if (count != 1) {
    			sb.append(count);
    		}
    	}
    	
    	return sb.toString();
    	
    }
   
}