package baekjoon.DP.카드_구매하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] dp = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

		}

		dp[1] = arr[1];

		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + arr[1];
			for (int j = 1; j <= i; j++) {

				// System.out.println("i :" + i + ", j : " + j + ", d[i] : " + dp[i] + ", 비교값 :
				// " + (arr[j] + dp[i - j]));
				dp[i] = Math.max(dp[i], arr[j] + dp[i - j]);
			}
			// System.out.println();

		}
		System.out.println(dp[N]);
		// System.out.println(Arrays.toString(dp));
	}

}
