package baekjoon.DP.돌_게임_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            N  = Integer.parseInt(br.readLine());

		int[]          dp = new int[N + 5];

		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 0;

		for (int i = 5; i <= N; i++) {
			if (dp[i - 4] + dp[i - 3] + dp[i - 1] > 0) {
				dp[i] = 0;
			} else {
				dp[i] = 1;
			}

		}
		System.out.println(dp[N] == 0 ? "SK" : "CY");

	}
}