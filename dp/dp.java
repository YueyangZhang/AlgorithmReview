package dp;

public class dp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
		int n = Integer.parseInt(args[0]);
		dp a = new dp();
		System.out.println(a.climbStairs(n));

	}
	

//	    public int climbStairs(int n) {
//	        if (n <= 0) {
//				return 0;
//			}
//			if (n == 1) {
//	            return 1;
//	        }
//	        if (n == 2) {
//	            return 2;
//	        }
//	            return climbStairs(n - 1) + climbStairs(n - 2);
//	    }
	public int climbStairs(int n) {
        if (n <= 0) {
            return n;
        }
        int n1 = 1;
        int n2 = 1;
        for (int i = 1; i <= n - 1; i++) {
            int temp = n1;
            n1 += n2;
            n2 = temp;
        }
        return n1;
    }

}
