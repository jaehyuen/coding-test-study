package baekjoon.DP.리그_오브_레전설_Small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[] dp = new long[N + 1];

		// 디피 초기화
		// M초 전까지는 무조건 한번
		for (int i = 0; i < M; i++) {
			dp[i] = 1;
		}

		// M 초는 2번
		dp[M] = 2;

		// M초 다음부턴 현재초 - M, 현재초 - 1초의 값을 더해서 구함
		for (int i = M + 1; i <= N; i++) {
			dp[i] = (dp[i - 1] + dp[i - M]) % 1000000007;
		}

		System.out.println(dp[N]);

	}
}