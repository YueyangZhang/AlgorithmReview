package fibonacciSum;

public class Result {
	public static void main(String[] args) {
		int n = 29;
		Solution s = new Solution();
		MathApproach m = new MathApproach();
		System.out.println(s.FibonacciSum(n));
		System.out.println(m.FibonacciSum(n));
	}
}
