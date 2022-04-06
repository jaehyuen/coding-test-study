package baekjoon.DP.가장_긴_바이토닉_부분_수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
		int             N   = Integer.parseInt(br.readLine());
		StringTokenizer st  = new StringTokenizer(br.readLine());

		int[]           arr = new int[N];
		int[][]         dp  = new int[2][N];

		int             max = 0;

		//순방향, 역방항 lis를 구해준다
		for (int i = 0; i < N; i++) {
			arr[i]   = Integer.parseInt(st.nextToken());
			dp[0][i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && dp[0][j] + 1 > dp[0][i]) {
					dp[0][i] = dp[0][j] + 1;
				}
			}

		}

		for (int i = N - 1; i >= 0; i--) {
			dp[1][i] = 1;
			for (int j = N - 1; j >= i; j--) {
				if (arr[i] > arr[j] && dp[1][j] + 1 > dp[1][i]) {
					dp[1][i] = dp[1][j] + 1;
				}
			}
			//역방향, 순방향의 dp값을 더해서  나온 최대값 - 1 이 답이다
			max = Math.max(max, dp[0][i] + dp[1][i]);
		}

		System.out.println(max - 1);

	}
}