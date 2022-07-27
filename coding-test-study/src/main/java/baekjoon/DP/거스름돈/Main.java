package baekjoon.DP.거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            n  = Integer.parseInt(br.readLine());

		int[]          dp = new int[n + 2];

		for (int i = 1; i <= n; i++) {
			dp[i] = 100001;

			if (i >= 2) {
				dp[i] = Math.min(dp[i - 2] + 1, dp[i]);
			}
			if (i >= 5) {
				dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
			}
		}

		// 값이 크면 -1 출력
		System.out.println(dp[n] >= 100000 ? -1 : dp[n]);

	}
}