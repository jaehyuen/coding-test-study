package baekjoon.DP.일이삼_더하기_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		long[] dp = new long[100001];

		// 초기값 선언
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 2;

		for (int i = 4; i <= 100000; i++) {

			// 양쪽에 2를 붙이는 경우, 1을 붙이는 경우, 6을 붙이는 경우를 더해줌
			if (i < 6) {
				dp[i] = (dp[i - 2] + dp[i - 4]) % 1000000009;
			} else {
				dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009;

			}
		}

		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}

	}
}
