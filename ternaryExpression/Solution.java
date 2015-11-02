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
		
		TreeNode node = new TreeNode(String.valueOf(s.charAt(0)));
		TreeNode root = node;
		char[] sc = s.toCharArray();
		int n = sc.length;
		Stack<TreeNode> stack = new Stack<>();
		
		/* only need to check ? and :
		 * node is always the treenode that is operated last time
		 * the node in stack is either the node without right or the parent of current node
		 * the left part is always filled before right part 
		 */
		for (int i = 1; i < n; i += 2) {
			if (sc[i] == '?') {
				// the one after ? is always a left child
				node.left = new TreeNode(String.valueOf(sc[i + 1]));
				stack.push(node);
				node = node.left;
			} else if (sc[i] == ':') {
				// the one after : is always a right child
				node = stack.pop();
				while (node.right != null) {
					node = stack.pop();
				} 
				node.right = new TreeNode(String.valueOf(sc[i + 1]));
				//stack.push(node);
				node = node.right;
			}
		}
		
		return root;
		
//		// create tree nodes with index
//		int n = s.length();
//		Map<Integer, TreeNode> map = new HashMap<>();
//		for (int i = 0; i < n; i += 2) {
//			map.put(i, new TreeNode(String.valueOf(s.charAt(i))));
//			
//		}
//		
//		// only check ? and :
//		Stack<TreeNode> stack = new Stack<>();
//		int i = 1;
//		while (i < n) {
//			if(i < n && s.charAt(i) == '?') {
//				// ? means a new top and push it to stack
//				TreeNode now = map.get(i - 1);
//				if (i - 2 > -1 && s.charAt(i - 2) != ':') {
//					// this top is the left child of its parent
//					stack.peek().left = now;
//				}
//				
//				stack.push(now);
//				i += 2;	
//			} else if (i < n && s.charAt(i) == ':') {
//				//: means the char after it must be a right child
//				TreeNode top = stack.pop();
//				TreeNode right = map.get(i + 1);
//				top.right = right;
//				if (i - 2 > -1 && s.charAt(i - 2) != ':') {
//					// we know this part exactly, so we can connect them
//					TreeNode left = map.get(i - 1);
//					top.left = left;
//				}
//			
//				i += 2;
//			}
//		}
			
	}
	
	
	public static void main(String[] args) {
		//String s = "a?b?c:d?e:f:g";
		String s = "a?b:c?d?e:f:g";
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
