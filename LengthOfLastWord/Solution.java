package LengthOfLastWord;

public class Solution {
	public int lengthOfLastWord(String s) {
        int length = 0;
        char[] c = s.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (length == 0) {
                if(c[i] == ' ') {
                    continue;
                }
                else {
                    length++;
                }
            }
            
            else{
                if (c[i] == ' '){
                    break;
                }
                else {
                    length++;
                }
            }
        }
        return length;
    }
}
