package ZigZag;

import java.util.Arrays;

public class Solution {
    public String convert(String s, int nRows) {
        int length = s.length();
        if (length <= nRows || nRows <= 1) {
            return s;
        }
        char[] result = new char[length];
        int step = 2 * nRows - 2;
        int interval = step;
        int count = 0;
        for (int i = 0; i < nRows; i++) {
            interval = step - 2;
            for (int j = i; j < length; j += step) {
                result[count] = s.charAt(j);
                count++;
                if (interval > 0 && interval < step && 
                    j + interval < length && count < length) {
                    result[count] = s.charAt(j + interval);
                    count++;
                }
            }            
        }
        return Arrays.toString(result);
    }
}