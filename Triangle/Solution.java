package Triangle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Solution {
	public static void main(String[] args) throws IOException {
		List<List<Integer>> tri = new ArrayList<>();
		try {
	        FileReader reader = new FileReader("bin/Triangle/triangle.txt");
	        BufferedReader br = new BufferedReader(reader);
	        String line = br.readLine();
	        while (line != null) {
	        	List<Integer> list = new ArrayList<>();
	        	String[] array = line.split("\\s");
	        	for (String s: array) {
	        		list.add(Integer.parseInt(s));
	        	}
	        	tri.add(list);
	        	line = br.readLine();
	        }
	        br.close();
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(maxTotal(tri));
	}
	
	public static int maxTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }    
        
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
}
