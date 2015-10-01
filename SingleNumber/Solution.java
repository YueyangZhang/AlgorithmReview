package SingleNumber;

import java.util.Arrays;

public class Solution {
    public int singleNumber(int[] A) {

        if (A == null || A.length == 0) {
            return -1;
        }
        
        Arrays.sort(A);
        int a = 0;
        for (int i = 0; i < A.length -1 ;i += 2) {
            if (A[i] != A[i + 1]) {
                a = i;
                break;
            }
        }
        
        if(A.length > 1 && A[0] == A[1] && a == 0) {
            return A[A.length -1 ];
        }
        return A[a];
    }
}