package baekjoon.DP.µ¿Àü_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n];
		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 1; i <= k; i++) {
			dp[i] = 10001;

			for (int coin : coins) {
				if (coin <= i)
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		System.out.println(dp[k] < 10001 ? dp[k] : -1);
	}
}
