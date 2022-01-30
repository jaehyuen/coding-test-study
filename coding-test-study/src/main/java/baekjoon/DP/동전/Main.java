package baekjoon.DP.µ¿Àü;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				coins[j] = Integer.parseInt(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			long[] dp = new long[M + 1];
			dp[0] = 1;

			for (int j = 0; j < N; j++) {
				for (int k = coins[j]; k <= M; k++) {
					dp[k] = dp[k] + dp[k - coins[j]];
				}
				System.out.println(Arrays.toString(dp));
			}
			System.out.println();

			//System.out.println("test : " + i);
			System.out.println(dp[M]);

		}
	}
}
