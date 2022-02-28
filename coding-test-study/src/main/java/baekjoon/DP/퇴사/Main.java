package baekjoon.DP.퇴사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr1 = new int[N];
		int[] arr2 = new int[N];

		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			arr1[i] = Integer.parseInt(st.nextToken());
			arr2[i] = Integer.parseInt(st.nextToken());

		}

		for (int i = 0; i < N; i++) {
			if (i + arr1[i] <= N) {
				dp[i + arr1[i]] = Math.max(dp[i + arr1[i]], dp[i] + arr2[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[N]);
		//System.out.println(Arrays.toString(dp));

	}
}