package app.dp;

public class fibonacci {
	public static int fib(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static int fibDp(int n, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		if (dp[n] != -1) {
//			System.out.println(dp[n]);
			return dp[n];
		} else {
			dp[n] = fibDp(n - 1, dp) + fibDp(n - 2, dp);
//			System.out.println(dp[n]);
			return dp[n];
		}
	}
	
	public static int sumOfNIntegers(int n) {
		if (n == 1) {
			return 1;
		}
		return n + sumOfNIntegers(n - 1);
	}
}
