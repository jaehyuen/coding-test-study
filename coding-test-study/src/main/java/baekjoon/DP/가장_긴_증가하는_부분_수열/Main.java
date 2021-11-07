package baekjoon.DP.가장_긴_증가하는_부분_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;

		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
					dp[i] = dp[j] + 1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}
