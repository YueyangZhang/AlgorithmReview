package PascalTriangle;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    	if (numRows == 0) {
            return result;
        }
        ArrayList<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> perRow = new ArrayList<>(i + 1);
            perRow.add(1);
            for(int j = 1; j < i; j++) {
                perRow.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            perRow.add(1);
            result.add(new ArrayList<Integer>(perRow));
        }
        return result;
    }
}