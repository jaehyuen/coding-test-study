package baekjoon.DP.RGB거리_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int            N   = Integer.parseInt(br.readLine());

		int[][]        arr = new int[N][3];
		int[][]        dp  = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		for (int k = 0; k < 3; k++) {

			for (int i = 0; i < 3; i++) {
				if (i == k)
					dp[0][i] = arr[0][i];
				else
					dp[0][i] = 1000 * 1000;
			}

			for (int i = 1; i < N; i++) {
				dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
			}

			for (int i = 0; i < 3; i++)
				if (i != k)
					min = Math.min(min, dp[N - 1][i]);
		}

		System.out.println(min);

	}
}