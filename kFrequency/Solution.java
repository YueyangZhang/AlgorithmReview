package kFrequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class Solution {
	public List<Integer> kFreq(int[] arr, int k) {
		List<Integer> rst = new ArrayList<>();
		if (arr == null || arr.length == 0) {
			return rst;
		}
		
		// count the frequency of each number
		Map<Integer, Integer> map = new HashMap<>();
		for (int num: arr) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		
		// new a min heap
		PriorityQueue<Entry<Integer, Integer>> heap = new PriorityQueue<>(k + 1, 
				new Comparator<Entry<Integer, Integer>>(){
					@Override
					public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
						return a.getValue() - b.getValue();
					}});
		
		// put entry to min heap and keep the size equals to k, > k poll the minimum number
		for (Entry<Integer, Integer> e: map.entrySet()) {
			heap.offer(e);
			if (heap.size() == k + 1) {
				heap.poll();
			}
		}
		
		// add numbers to result
		for (Entry<Integer, Integer> e: heap) {
			rst.add(e.getKey());
		}
		
		return rst;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,2,2,2,2,3,3,3,3,4,4,4,5,5,6};
		Solution s = new Solution();
		List<Integer> rst = s.kFreq(arr, 4);
		for (int n: rst) {
			System.out.println(n);
		}
	}
}
