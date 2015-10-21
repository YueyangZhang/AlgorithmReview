package BucketSort;

import java.util.Random;

/**
 * 
 * @author Yueyang Zhang
 * Time Complexity: O(n + k)
 * n is the number of numbers
 * k is the number of buckets
 */

public class BucketSort {
	
	static int[] bucketSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums;
		}
		
		int max = Integer.MIN_VALUE;
		for (int num: nums) {
			max = Math.max(max, num);
		}
		
		int[] bucket = new int[max + 1];
		int[] result = new int[nums.length];
		for (int num: nums) {
			bucket[num]++;
		}
		
		int start = 0;
		for(int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				result[start++] = i;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Random random = new Random();
	    int n = 20;
	    int[] sequence = new int[n];
	 
	    for (int i = 0; i < n; i++) {
	    	sequence[i] = Math.abs(random.nextInt(100));
	    }
	    
	    int[] result = bucketSort(sequence);
	    
	    System.out.println("Original:");
	    for (int i = 0; i < n; i++) {
	    	System.out.print(sequence[i] + " ");
	    }
	    System.out.println();
	    
	    System.out.println("Sorted:");
	    for (int i = 0; i < n; i++) {
	    	System.out.print(result[i] + " ");
	    }
	}
}
