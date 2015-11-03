package median;

public class Solution {
    
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		int[] b = {1, 3, 4};
		System.out.println(findMedianSortedArrays(a, b));
	}
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKth(nums1, nums2, 0, 0, len / 2 - 1) + findKth(nums1, nums2, 0, 0, len / 2)) / 2.0;
        } else {
            return findKth(nums1, nums2, 0, 0, len / 2);
        }
    }
    
    private static int findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        
        if (start1 > nums1.length - 1) {
            return nums2[start2 + k];
        }
        
        if (start2 > nums2.length - 1) {
            return nums1[start1 + k];
        }
        
        if (k == 0) {
            return Math.min(nums1[start1], nums2[start2]);
        } 
        
        int half1 = start1 + k / 2 < nums1.length ? nums1[start1 + k / 2] : Integer.MAX_VALUE; 
        int half2 = start2 + k / 2 < nums2.length ? nums2[start2 + k / 2] : Integer.MAX_VALUE;
        
        if (half1 < half2) {
            return findKth(nums1, nums2, start1 + k / 2 + 1, 0, k - k / 2);
        } else {
            return findKth(nums1, nums2, 0, start2 + k / 2 + 1, k - k / 2);
        }
    }
}
