package baekjoon.DP.BABBA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());
		int[][]        dp = new int[N + 5][2];

		// dp 초기값 세팅

		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;

		for (int i = 3; i <= N; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		System.out.println(dp[N][0] + " " + dp[N][1]);
	}
}