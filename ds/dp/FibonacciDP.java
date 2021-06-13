package learn.ds.dp;

import java.util.Arrays;

class Fibo {

	public int fibonacci(int n, int[] dp) {

		if (n == 0 || n == 1 || n < 0) {
			return n;
		}
		if (dp[n] != -1) {
			return dp[n];
		} else {
			dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp);
		}

		return dp[n];
	}
}

public class FibonacciDP {
	public static void main(String args[]) {
		Fibo f = new Fibo();
		int dp[] = new int[8];
		Arrays.fill(dp, -1);
		int ret = f.fibonacci(7, dp);
		System.out.println("Fibo of 7 is:" + ret);
	}
}