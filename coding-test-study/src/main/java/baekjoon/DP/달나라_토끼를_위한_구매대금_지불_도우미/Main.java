package baekjoon.DP.달나라_토끼를_위한_구매대금_지불_도우미;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int[] coin = { 1, 2, 5, 7 };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 8];

		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;

		for (int i = 8; i <= N; i++) {
			dp[i] = dp[i - 1] + 1;
			for (int j = 0; j < 4; j++) {

				dp[i] = Math.min(dp[i - coin[j]] + 1, dp[i]);

			}

		}
		System.out.println(dp[N]);

	}

}
