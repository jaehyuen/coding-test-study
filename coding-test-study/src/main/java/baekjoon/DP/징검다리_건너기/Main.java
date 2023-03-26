package baekjoon.DP.징검다리_건너기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N + 1][2];

		// 점프 비용 저장
		for (int i = 1; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = a;
			arr[i][1] = b;
		}
		int K = Integer.parseInt(br.readLine());

		// 디피 선언
		// dp[i][0] = 매우 큰 점프를 안한 최소값
		// dp[i][0] = 매우 큰 점프를 한번한 최소값
		int[][] dp = new int[N + 3][2];

		// 초기값 설정
		dp[2][0] = arr[1][0];
		dp[2][1] = Integer.MAX_VALUE;

		for (int i = 3; i <= N; i++) {
			// 현재 위치에서 1개전, 2개전에서 온것중 작은값 설정
			dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);

			if (i == 4) {
				// 현재 위치가 4이면 매우 큰 점프를 뜀
				dp[4][1] = K;
			} else if (i == 5) {
				// 현재 위치가 1번에서 매우 큰 점프를 뛰거나 매우큰 점프를 뛰엇던 곳에서 작은 점프를 뛴것중 작은거 설정
				dp[5][1] = Math.min(dp[4][1] + arr[4][0], dp[i - 3][0] + K);
			} else if (i > 5) {

				// 현재 위치가 6부터는 아래 셋중 최소값을 저장
				// 1. 매우 큰 점프를 뛰엇던 1칸 전 최소값에서 작은 점프를 뛴다
				// 2. 매우 큰 점프를 뛰엇던 2칸 전 최소값에서 큰 점프를 뛴다
				// 3. 매우 큰 점프를 안뛰고 3칸 전 최소값에서 매우 큰 점프를 뛴다
				dp[i][1] = Math.min(dp[i - 1][1] + arr[i - 1][0],
						Math.min(dp[i - 2][1] + arr[i - 2][1], dp[i - 3][0] + K));
			} else {
				dp[i][1] = Integer.MAX_VALUE;
			}
		}
		System.out.println(Math.min(dp[N][0], dp[N][1]));

	}
}