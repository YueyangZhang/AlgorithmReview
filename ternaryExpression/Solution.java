package ternaryExpression;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Solution {
	public TreeNode convert(String s) {
		if (s == null || s.length() == 0) {
			return null;
		}
		
		if (s.length() == 1) {
			return new TreeNode(s);
		}
		
		// create tree nodes with index
		int n = s.length();
		Map<Integer, TreeNode> map = new HashMap<>();
		for (int i = 0; i < n; i += 2) {
			map.put(i, new TreeNode(String.valueOf(s.charAt(i))));
			
		}
		
		Stack<TreeNode> stack = new Stack<>();
		int i = 1;
		while (i < n) {
			if(i < n && s.charAt(i) == '?') {
				TreeNode now = map.get(i - 1);
				if (i - 2 > -1 && s.charAt(i - 2) != ':') {
					stack.peek().left = now;
				}
				
				stack.push(now);
				i += 2;	
			} else if (i < n && s.charAt(i) == ':') {
				TreeNode top = stack.pop();
				TreeNode right = map.get(i + 1);
				top.right = right;
				if (i - 2 > -1 && s.charAt(i - 2) != ':') {
					TreeNode left = map.get(i - 1);
					top.left = left;
				}
			
				i += 2;
			}
		}
		
		return map.get(0);	
	}
	
	
	public static void main(String[] args) {
		String s = "a?b?c:d?e:f:g";
		Solution r = new Solution();
		TreeNode result = r.convert(s);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(result);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode now = queue.poll();
				System.out.print(now.val);
				if (now.left != null) {
					queue.offer(now.left);
				} else {
					System.out.print("(no left) ");
				}
				
				if (now.right != null) {
					queue.offer(now.right);
				} else {
					System.out.print("(no right) ");
				}
				
			}
			
			System.out.println();
		}
	}
}
