package Palindrome;

public class Panlindrome {
	public static void main(String[] args) {
		String s = "Aa";
		Panlindrome p = new Panlindrome();
		System.out.println(p.isPalindrome(s));
	}
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s == null) {
            return true;
        }
        s = s.toLowerCase();
        System.out.println(s);
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < s.length() - 1 && ! isValid(s.charAt(left))) {
                left ++;
            }
            if (left == s.length() -1) {
                return true;
            }
            while (right > 0 && ! isValid(s.charAt(right))) {
                right--;
            }
            
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left ++;
                right --;
            }
        }
        return true;
    }
    
    private boolean isValid(char a) {
        return Character.isLetter(a) || Character.isDigit(a);
    }
    
}
