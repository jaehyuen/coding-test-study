package baekjoon.DP.≈∏¿œ∏µ2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();

		int[] dp = new int[T + 2];

		dp[0] = 1;
		dp[1] = 3;

		for (int i = 2; i < T; i++) {
			dp[i] = ((dp[i - 2] * 2) + dp[i - 1]) % 10007;
		}

		System.out.println(dp[T - 1]);

	}

}
