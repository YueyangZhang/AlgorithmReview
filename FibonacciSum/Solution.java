package fibonacciSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
	
	boolean found = false;
	
	public String FibonacciSum(int n) {
		if (n <= 0) {
			return null;
		}
		
		if (n == 1) {
			return "1";
		}
		
		if (n == 2) {
			return "10";
		}
		
		ArrayList<Integer> fib = new ArrayList<>();
		int first = 0;
		int second = 1;
		int current = 0;
		while (current < n) {
			current = first + second;
			if (current < n) {
				fib.add(current);
			}
			
			first = second;
			second = current;
		}
		
		List<List<Integer>> rst = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(rst, fib, n, 0, list);
		
		HashSet<Integer> set = new HashSet<>();
		if (rst.size() != 0) {
			for (int num: rst.get(0)) {
				set.add(num);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < fib.size(); i++) {
			if (set.contains(fib.get(i))) {
				sb.append(1);
			} else {
				sb.append(0);
			}
		}
		
		String str = sb.toString();
		int i = 0;
		while (str.charAt(i) == '0') {
			i++;
		}
		
		return str.substring(i, str.length());
	}
	
	private void helper(List<List<Integer>> rst, ArrayList<Integer> fib, int target, int pos, List<Integer> list) {
		if (target == 0) {
			found = true;
			rst.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i = pos; i < fib.size(); i++) {
			if (fib.get(i) > target) {
				break;
            }
			
			list.add(fib.get(i));
			helper(rst, fib, target - fib.get(i), i + 1, list);
			if (found == true) {
				return;
			} else {
				list.remove(list.size() - 1);
			}
		}
	}
}
