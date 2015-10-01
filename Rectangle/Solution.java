package Rectangle;

import java.util.Stack;

public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
	
	public static void main(String[] args) {
		int[] height = {1,1,3,3,4,3,5,3,3,5,7};
		System.out.println(largestRectangleArea(height));
	}
    public static int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int largest = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = (i == height.length) ? -1 : height[i];
            while (!stack.empty() && cur < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.empty() ? i : i - stack.peek() - 1;
                largest = Math.max(largest, h * w);
            }
            
            stack.push(i);
        }
        
        return largest;
    }
}
