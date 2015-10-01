package PermutatutionSequence;

import java.util.ArrayList;

public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb  = new StringBuilder();
        ArrayList<Integer> nums = new ArrayList<>();
        
        for (int i = 1; i <= n; n++) {
            nums.add(i);
        }
        
        k--; // start from 1 to start from 0 
        
        int factor = 1;
        for (int i = 1; i < n ; i++) {
            factor *= i;
        }
        
        int divisor = n - 1;
        while (divisor >= 0) {
            int index = k / factor; // the index of this n 
            k = k % factor; // kth in new n 
            sb.append(nums.get(index));
            nums.remove(index);
            factor = factor/ divisor; //renew (n-1)!
            divisor--;
        }
        
        return sb.toString();
    }
}
