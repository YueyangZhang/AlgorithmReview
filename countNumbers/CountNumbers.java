package countNumbers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class CountNumbers {
	public int[] countNumbers(int[] a, int[] b) {
		if (a == null || b == null || a.length < b.length) {
			return null;
		}
		
		int[] c = new int [b.length];
		for (int i = 0; i < c.length; i++) {
			c[i] = -1;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num:a) {
			int temp = 0;
			if (map.containsKey(num)) {
				temp = map.get(num);
			}
			
			temp++;
			map.put(num, temp);
		}
		
		Set<Integer> set = map.keySet();
		for (int i = 0; i < b.length; i++) {
			Iterator<Integer> it = set.iterator();
			while (it.hasNext()) {
				int key = it.next();
				int value = map.get(key);
				if (value == b[i]) {
					c[i] = key;
					set.remove(key);
					break;
				}
			}
		}
		
		//Map<Integer, ArrayList<Integer>> newMap = HashMap<>
		
		return c;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,2,2,3,3,4,4};
		int[] b = {2,2,3,2,2};
		CountNumbers c = new CountNumbers();
		int[] rst = c.countNumbers(a, b);
		System.out.println(Arrays.toString(rst));
	}
}
