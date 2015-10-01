import java.util.Arrays;


public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		RotateArray b = new RotateArray();
		b.rotate(nums, k);
		System.out.print(Arrays.toString(nums));
	}
	public void rotate(int[] nums, int k) {
        int len = nums.length;
        int shift = k % len;
        int[] copy = new int[len];
        for (int i = 0 ; i < len; i++) {
            copy[i] = nums[(len - shift + i) % len];
        }
        
        for (int i = 0 ; i < len ; i ++) {
            nums[i] = copy[i];
        }       
    }
}
