package baekjoon.DP.파스칼의_삼각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int             n  = Integer.parseInt(st.nextToken());
		int             k  = Integer.parseInt(st.nextToken());

		int[][]         dp = new int[n][n];
		dp[0][0] = 1;
		dp[1][0] = 1;
		dp[1][1] = 1;

		for (int i = 2; i < n; i++) {

			// 테두리 체우기
			dp[i][0] = 1;
			dp[i][i] = 1;

			for (int j = 1; j < i; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
			}

		}
		System.out.println(dp[n - 1][k - 1]);

	}
}