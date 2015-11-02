package kLargest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
	public static void main(String[] args) {
		int[] arr = new int[]{8, 2, 3, 4, 5, 7, 6, 1};
		List<Integer> result = KLargest(arr, 3);
		for (Integer num:result) {
			System.out.println(num);
		}
	}
	
	private static List<Integer> KLargest(int[] arr, int k) {
		List<Integer> rst = new ArrayList<>();
		if (arr == null || arr.length == 0 || k <= 0) {
			return rst;
		}
		
		Queue<Integer> queue = new PriorityQueue<>(k + 1);
		for (int i = 0; i < arr.length; i++) {
			queue.offer(arr[i]);
			if (queue.size() == k + 1) {
				queue.poll();
			}
		}
		
		for (Integer num:queue) {
			rst.add(num);
		}
		
		return rst;
	}
}
