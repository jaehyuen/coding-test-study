package baekjoon.DP.극장_좌석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// dp 선언
		int[] dp = new int[N + 1];

		// dp초기값 세팅
		dp[1] = 1;
		dp[0] = 1;

		// vip 자리가 없을떄 값을 구한다
		for (int i = 2; i <= N; i++) {

			dp[i] = dp[i - 1] + dp[i - 2];

		}

		int prev = 0;
		int now = 0;
		int result = 1;

		// vip 자리가 있는 구간별 dp값을 곱해서 답을 구한다
		for (int i = 0; i < M; i++) {
			now = Integer.parseInt(br.readLine());
			result *= dp[now - prev - 1];
			prev = now;
		}
		result *= dp[N - now];

		System.out.println(result);

	}
}