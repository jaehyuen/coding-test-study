package baekjoon.DP.진우의_달_여행;

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

		int[][] arr = new int[N + 1][M + 1];
		int[][][] dp = new int[N + 2][M + 2][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			// 범위 밖 초기화
			dp[i][0][0] = 99999999;
			dp[i][0][1] = 99999999;
			dp[i][0][2] = 99999999;
			dp[i][M + 1][0] = 99999999;
			dp[i][M + 1][1] = 99999999;
			dp[i][M + 1][2] = 99999999;

			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				// 처음위치 초기화
				if (i == 1) {
					dp[i][j][0] = arr[i][j];
					dp[i][j][1] = arr[i][j];
					dp[i][j][2] = arr[i][j];
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= M; j++) {

				for (int k = 0; k < 3; k++) {
					switch (k) {
						case 0:
							// 왼쪽 대각선에서 온 경우
							// 이전 최소 값중에 방향이 안겹치는 1, 2번중 최소값을 선택
							dp[i][j][0] = Math.min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2]) + arr[i][j];
							break;
						case 1:
							// 직선으로 온 경우
							// 이전 최소 값중에 방향이 안겹치는 0, 2번중 최소값을 선택
							dp[i][j][1] = Math.min(dp[i - 1][j][0], dp[i - 1][j][2]) + arr[i][j];
							break;
						case 2:
							// 오른쪽 대각선에서 온 경우
							// 이전 최소 값중에 방향이 안겹치는 0, 1번중 최소값을 선택
							dp[i][j][2] = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]) + arr[i][j];
							break;
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;

		// 최소값 탐색
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 3; j++) {
				min = Math.min(min, dp[N][i][j]);
			}
		}
		System.out.println(min);

	}
}