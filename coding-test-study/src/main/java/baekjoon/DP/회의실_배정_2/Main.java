package baekjoon.DP.회의실_배정_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			st.nextToken();
			int tmp = Integer.parseInt(st.nextToken());
			if (i == 0) {

				dp[i] = tmp;
			} else if (i == 1) {
				dp[i] = Math.max(dp[i - 1], tmp);
			} else {
				dp[i] = Math.max(dp[i - 2] + tmp, dp[i -1]);
			}
		}

		System.out.println(dp[N - 1]);
	}
}
