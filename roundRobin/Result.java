package roundRobin;

public class Result {
	public static void main(String[] args) {
		int[] arrivetime = {0, 1, 3, 9};
		int[] excutetime = {2, 1, 7, 5};
		Solution s = new Solution();
		System.out.println(s.roundRobin(arrivetime, excutetime, 3));
	}
}
