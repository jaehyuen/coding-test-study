package baekjoon.DP.자원_캐기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int tmp = Integer.parseInt(st.nextToken());

				if (i == 0 && j == 0) {
					dp[i][j] = tmp;
				} else if (i == 0) {
					dp[i][j] = tmp + dp[i][j - 1];
				} else if (j == 0) {
					dp[i][j] = tmp + dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + tmp;
				}
			}
		}

		System.out.println(dp[N - 1][M - 1]);
	}
}
