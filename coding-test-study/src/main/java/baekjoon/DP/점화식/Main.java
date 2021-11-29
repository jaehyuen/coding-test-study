package baekjoon.DP.점화식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int            n  = Integer.parseInt(br.readLine());

		long[]         dp = new long[n + 2];

		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			long sum = 0;
			for (int j = 0; j < i; j++) {
				sum += dp[j] * dp[i - j - 1];

			}
			dp[i] = sum;

		}

		System.out.println(dp[n]);

	}

}