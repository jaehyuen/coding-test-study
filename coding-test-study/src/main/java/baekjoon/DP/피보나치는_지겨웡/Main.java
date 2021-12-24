package baekjoon.DP.피보나치는_지겨웡;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		dp = new int[N + 3];

		System.out.println(fibonacci(N));
	}

	public static int fibonacci(int n) {
		if (n < 2) {
			return 1;
		} else if (dp[n] == 0) {

			dp[n] = (fibonacci(n - 2) + fibonacci(n - 1) + 1) % 1000000007;

		}
		return dp[n];

//		dp[0] = 1;
//		dp[1] = 1;
//
//		for (int i = 2; i <= n; i++) {
//			dp[i] = (dp[i - 2] + dp[i - 1] + 1) % 1000000007;
//		}
//		return 0;

	}

}
