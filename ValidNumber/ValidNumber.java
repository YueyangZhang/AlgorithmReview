package ValidNumber;

public class ValidNumber {
	
	public static void main(String[] args) {
		String s = "++";
		String newS = s.trim();
		System.out.println(newS);
		System.out.println(isNumber(s));
		
	}
	
	
	public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }                
        
        // clear the white space
        String newS = s.trim();
        if (newS.isEmpty()) {
            return false;
        }
        
        int i = 0;
        int e = newS.length() - 1;
        // skip +/-
        if (newS.charAt(i) == '+' || newS.charAt(i) == '-') {
            i++;
        }
        
        boolean num = false; // there's number before
        boolean dot = false; // there's dot before
        boolean exp = false; // thers's e before
        
        while (i <= e) {
            char c = newS.charAt(i);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (dot || exp) {
                    return false;
                }
                
                dot = true;
            } else if (c == 'e') {
                if (exp == true || num == false) {
                    return false;
                }
                
                exp = true;
                num = false;
                
            } else if (c == '+' || c == '-') {
                if (newS.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            i++;
        }
        return num;
    }
}
